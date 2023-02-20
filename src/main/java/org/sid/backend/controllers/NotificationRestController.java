package org.sid.backend.controllers;
import lombok.Data;
import org.sid.backend.domaine.NotificationVo;
import org.sid.backend.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class NotificationRestController {
@Autowired
private NotificationService notificationService;
//save notification
//@PostAuthorize("hasAuthority('ADMIN')")



//    //@PostMapping(path ="/saveNotification")
//public void saveNotification() {
//        notificationService.saveNotification();
//    }

//get notification by id activite

    //getNotification
    @GetMapping(path ="/getNotification")
    @PostAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<NotificationVo> getNotification(){
        return notificationService.getNotification();
    }
//hahia



    @PostMapping(path ="/addNotificationToUsers")
    @PostAuthorize("hasAuthority('ADMIN')")
    public void addNotificationToUsers(@RequestBody NotificationRestController.UserNotificationForm userNotificationForm){
        notificationService.addNotificationToUsers(userNotificationForm.getNameNotification(),userNotificationForm.getIdActivite());
    }

//save notification
//    @PostMapping(path ="/saveNotification")
//    @PostAuthorize("hasAuthority('ADMIN')")
//    public void saveNotification(@RequestBody NotificationRestController.NotificationForm notificationForm){
//        notificationService.saveNotification(notificationForm.getNameNotification(),notificationForm.getIdActivite(),notificationForm.getDateNotification());
//    }



//    @Data
//    static class NotificationForm {
//        private String nameNotification;
//        private Long idActivite;
//        private String dateNotification;
//    }


    @Data
    static class UserNotificationForm {
        private String nameNotification;
        private Long idActivite;
    }
}
