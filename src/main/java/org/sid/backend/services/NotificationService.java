package org.sid.backend.services;
import org.sid.backend.domaine.NotificationVo;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.List;
public interface NotificationService {
    //get all notifications
    List<NotificationVo> getAllNotifications();
    //get notification by id
    NotificationVo getNotificationById(Long id);
    //save notification
   //void saveNotification(NotificationVo notificationVo);
    //addUNotificationToUser
    void addNotificationToUsers(String nameNotification,Long idActivite);
    // get all notifications by user
    //List<NotificationVo> getAllNotificationsByUser(Long idUser);

    void saveNotification();

  //  List<NotificationVo> getNotificationByIdActivite(Long valueOf);
            List <NotificationVo> getNotification();
//    void saveNotification( NotificationVo notificationVo);
//
//
//    //update notification
//    NotificationVo updateNotification(NotificationVo notificationVo);
//    //delete notification
//    void deleteNotification(Long id);

}
