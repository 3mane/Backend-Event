package org.sid.backend.sec.web;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import org.sid.backend.sec.JwtUtil;
import org.sid.backend.sec.entities.AppRole;
import org.sid.backend.sec.entities.AppUser;
import org.sid.backend.sec.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;


@RestController
public class AccountRestController {

    private AccountService accountService;

   public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
    }

//get user by id
    @GetMapping(path = "/user/{id}")
    @PostAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public AppUser getUser(@PathVariable Long id){
        return accountService.getUser(id);
    }

//register user
    @PostMapping(path ="/register")
    public AppUser register(@RequestBody RegisterForm userForm){
        if(!userForm.getPassword().equals(userForm.getPassword()))
            throw new RuntimeException("You must confirm your password");
        AppUser user=accountService.loadUserByUsername(userForm.getUsername());
        if(user!=null) throw new RuntimeException("This user already exists");
        AppUser appUser=new AppUser();
        //register
        appUser.setUsername(userForm.getUsername());
        appUser.setPassword(userForm.getPassword());
        appUser.setNom(userForm.getNom());
        appUser.setPrenom(userForm.getPrenom());
        appUser.setEmail(userForm.getEmail());
        appUser.setTel(userForm.getTel());
        appUser.setAdresse(userForm.getAdresse());
        accountService.addNewUser(appUser);
        accountService.addRoleToUser(userForm.getUsername(),"USER");
        return appUser;
    }



    @GetMapping(path = "/users")
    @PostAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<AppUser> listUsers(){
        return accountService.listUsers();
   }
    //list users with roles
//    @GetMapping(path = "/usersWithRoles")
//    @PostAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
//    public List<AppUser> listUsersWithRoles(){
//        return accountService.listUsersWithRoles();
//    }

    @PostMapping(path ="/users")
    @PostAuthorize("hasAuthority('ADMIN')")
    public AppUser saveUser(@RequestBody AppUser appUser){
        return accountService.addNewUser(appUser);
    }

    //update user
    @PutMapping(path ="/user/{id}")
    @PostAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public ResponseEntity<Object>  updateUser(@PathVariable Long id,@Valid @RequestBody AppUser appUser){
       /*  EvenementVo evenementVoFound= evenementService.getEvenementById(evenementVoId);
        if (evenementVoFound == null) {
            return new ResponseEntity<>("Evenement not found", HttpStatus.OK);
        }
        evenementVo.setId(evenementVoId);
        evenementVo.setDateDebut(evenementVoFound.getDateDebut());
        evenementVo.setDateFin(evenementVoFound.getDateFin());
        evenementVo.setDescription(evenementVoFound.getDescription());
        evenementVo.setName(evenementVoFound.getName());
        evenementService.updateEvenement(evenementVo);
        return new ResponseEntity<>("Evenement updated successfully", HttpStatus.OK);*/
        AppUser appUserFound = accountService.getUser(id);
        if (appUserFound == null) {
            return new ResponseEntity<>("User not found", HttpStatus.OK);
        }
        appUser.setId(id);
        appUser.setNom(appUserFound.getNom());
        appUser.setPrenom(appUserFound.getPrenom());
        appUser.setEmail(appUserFound.getEmail());
        appUser.setTel(appUserFound.getTel());
        appUser.setAdresse(appUserFound.getAdresse());
        accountService.updateUser(appUser);
        return new ResponseEntity<>("User updated successfully", HttpStatus.OK);

       // return accountService.updateUser(appUser);
    }

    @PostMapping(path ="/roles")
    @PostAuthorize("hasAuthority('ADMIN')")
    public AppRole saveRole(@RequestBody AppRole appRole){
        return accountService.addNewRole(appRole);
    }

    @PostMapping(path ="/addRoleToUser")
    @PostAuthorize("hasAuthority('ADMIN')")
    public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
    }
    @GetMapping(path = "/refreshToken")
public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws  Exception{
String authToken = request.getHeader(JwtUtil.Auth_Header);
if(authToken != null && authToken.startsWith(JwtUtil.PREFIX)){
    try {
        String jwt=authToken.substring(JwtUtil.PREFIX.length());
        Algorithm algorithm=Algorithm.HMAC256(JwtUtil.SECRET);
        JWTVerifier jwtVerifier= JWT.require(algorithm).build();
        jwtVerifier.verify(jwt);
        DecodedJWT decodedJWT=jwtVerifier.verify(jwt);
        String username=decodedJWT.getSubject();
        AppUser appUser=accountService.loadUserByUsername(username);
        String jwtAccessToken= JWT.create()
                .withSubject(appUser.getUsername())
                .withExpiresAt(new java.util.Date(System.currentTimeMillis()+JwtUtil.EXPIRE_ACCESS_TOKEN))
                .withIssuer(request.getRequestURL().toString())
                .withClaim("roles", appUser.getAppRoles()
                                .stream().map(r -> r.getRoleName())
                                .collect(Collectors.toList())).sign(algorithm);
        Map<String,String> idToken=new java.util.HashMap<>();
        idToken.put("access-token",jwtAccessToken);
        idToken.put("refresh-token",jwt);
        response.setContentType("application/json");
        new ObjectMapper().writeValue(response.getOutputStream(),idToken);


    }catch (Exception e){
        throw e;
    }
}
else {
    throw new RuntimeException("Refresh token required");
}
}
@GetMapping(path = "/profile")
public AppUser profile(Principal principal){
       return accountService.loadUserByUsername(principal.getName());
}

    @Data
    static class RoleUserForm{
        private String username;
        private String roleName;
    }

    @Data
    static class RegisterForm {
        private String username;
        private String password;
        private String nom;
        private String prenom;
        private String email;
        private String tel;
        private String adresse;
    }
}





