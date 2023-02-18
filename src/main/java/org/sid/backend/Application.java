package org.sid.backend;
import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.domaine.NotificationVo;
import org.sid.backend.sec.entities.AppRole;
import org.sid.backend.sec.entities.AppUser;
import org.sid.backend.sec.service.AccountService;
import org.sid.backend.services.ActiviteService;
import org.sid.backend.services.NotificationService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true,securedEnabled = true)
@EnableScheduling
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
    @Bean
    CommandLineRunner start(AccountService accountService ){
        return args -> {
            accountService.addNewRole(new AppRole(null,"USER"));
            accountService.addNewRole(new AppRole(null,"ADMIN"));
            accountService.addNewRole(new AppRole(null,"RESPONSABLE"));
            accountService.addNewUser(new AppUser(null, "user1", "Ayoub","Labied","0666666666","lakhmiss bettana sale","ayoub@gmail.com","1234", new ArrayList<>(),new HashSet<>(),new ArrayList<>()));
            accountService.addNewUser(new AppUser(null,"admin", "OTHmane","benomar","0666666666","elmassira bettana sale","ayoub@gmail.com","1234",new ArrayList<>(),new HashSet<>(),new ArrayList<>()));
           accountService.addNewUser(new AppUser(null,"user2", "Hamza","benomar","0666666666","elmassira bettana sale","ayoub@gmail.com","1234",new ArrayList<>(),new HashSet<>(),new ArrayList<>()));
            accountService.addRoleToUser("user1","USER");
           //accountService.addRoleToUser("admin","USER");
            accountService.addRoleToUser("admin","ADMIN");
          accountService.addRoleToUser("user2","RESPONSABLE");

           // notificationService.saveNotification(new NotificationVo(null,"user1","1",null,"Activite",new Date(),false,new HashSet<>(),new ActiviteVo()));

        };
    }

}
