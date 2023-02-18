package org.sid.backend.sec.service;
import org.sid.backend.sec.entities.AppRole;
import org.sid.backend.sec.entities.AppUser;
import org.sid.backend.sec.repo.AppRoleRepository;
import org.sid.backend.sec.repo.AppUserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
@Service
@Transactional
public class AccountServiceImpl implements AccountService {



    //injection de depandance par constructeur et mieux que autowired
                //@Autowired

    private  AppUserRepository appUserRepository;
    private  AppRoleRepository appRoleRepository;
    private  PasswordEncoder passwordEncoder;


    public AccountServiceImpl(
            AppUserRepository appUserRepository,
            AppRoleRepository appRoleRepository,
            PasswordEncoder passwordEncoder)
    {
        this.appUserRepository = appUserRepository;
        this.appRoleRepository = appRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }


    @Override
    public AppUser addNewUser(AppUser appUser) {
        String pwd = appUser.getPassword();
        appUser.setPassword(passwordEncoder.encode(pwd));
        return appUserRepository.save(appUser);
    }

    @Override
    public AppRole addNewRole(AppRole appRole) {
        return appRoleRepository.save(appRole);
    }

    @Override
    public void addRoleToUser(String username, String roleName) {
        AppUser appUser = appUserRepository.findByUsername(username);
        AppRole appRole = appRoleRepository.findByRoleName(roleName);
        appUser.getAppRoles().add(appRole);
    }

    @Override
    public AppUser loadUserByUsername(String username) {
        return appUserRepository.findByUsername(username);
    }

    @Override
    public List<AppUser> listUsers() {
        //set roles
        return appUserRepository.findAll();
    }

    @Override
    public AppUser getUser(Long id) {
        return appUserRepository.findById(id).get();
    }

    @Override
    public AppUser updateUser(AppUser appUser) {
        return appUserRepository.save(appUser);
    }


}
