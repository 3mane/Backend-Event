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
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.util.*;
import java.util.stream.Collectors;


@RestController
public class AccountRestController {

    private AccountService accountService;

   public AccountRestController(AccountService accountService) {
        this.accountService = accountService;
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
}





