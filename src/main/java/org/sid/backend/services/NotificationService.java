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

    void saveNotification();
    void saveNotification( NotificationVo notificationVo);


    //update notification
    NotificationVo updateNotification(NotificationVo notificationVo);
    //delete notification
    void deleteNotification(Long id);

}
