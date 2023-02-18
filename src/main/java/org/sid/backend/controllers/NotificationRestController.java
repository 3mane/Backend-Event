package org.sid.backend.controllers;
import lombok.Data;
import org.sid.backend.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class NotificationRestController {
@Autowired
private NotificationService notificationService;
//save notification
@PostAuthorize("hasAuthority('ADMIN')")



    //@PostMapping(path ="/saveNotification")
public void saveNotification() {
        notificationService.saveNotification();
    }




    @PostMapping(path ="/addNotificationToUsers")
    @PostAuthorize("hasAuthority('ADMIN')")
    public void addNotificationToUsers(@RequestBody NotificationRestController.UserNotificationForm userNotificationForm){
        notificationService.addNotificationToUsers(userNotificationForm.getNameNotification(),userNotificationForm.getIdActivite());
    }


    @Data
    static class UserNotificationForm {
        private String nameNotification;
        private Long idActivite;
    }
}
