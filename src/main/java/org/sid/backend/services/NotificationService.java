package org.sid.backend.services;
import org.sid.backend.domaine.NotificationVo;
import java.util.List;
public interface NotificationService {
    //get all notifications
    List<NotificationVo> getAllNotifications();
    //get notification by id
    NotificationVo getNotificationById(Long id);
    //save notification
   void saveNotification(NotificationVo notificationVo);
    //update notification
    NotificationVo updateNotification(NotificationVo notificationVo);
    //delete notification
    void deleteNotification(Long id);
    //find by user
//    List<NotificationVo> findByUserNotification(Long idUser);
//    //find by activity
//    List<NotificationVo> findByActiviteNotification(Long idActivite);
//    //find by event
//    List<NotificationVo> findByEvenementNotification(Long idEvenement);
//    //find by type
////    List<NotificationVo> findByTypeNotification(String type);
//    //find by confirmed
//    List<NotificationVo> findByConfirmedNotification(boolean confirmed);
//    //find by date
//    List<NotificationVo> findByDateNotification(String date);
//    //send notification to user
//    void sendNotificationToUser(Long idUser, String type, Long idActivite, Long idEvenement);
//    //send notification to all users
//    void sendNotificationToAllUsers(String type, Long idActivite, Long idEvenement);
//    //send notification to all users of an activity
//    void sendNotificationToAllUsersOfAnActivity(String type, Long idActivite);
//    //send notification to all users of an event
//    void sendNotificationToAllUsersOfAnEvent(String type, Long idEvenement);
//    //send notification to all users of an activity and an event
//    //void sendNotificationToAllUsersOfAnActivityAndAnEvent(String type, Long idActivite, Long idEvenement);
//    //send notification to all users of an activity or an event
//    //void sendNotificationToAllUsersOfAnActivityOrAnEvent(String type, Long idActivite, Long idEvenement);
//    //send notification to users of an activity by date debut activity
//    void sendNotificationToUsersOfAnActivityByDateDebutActivity(String type, Long idActivite , String date);
//    // send notification to users of an event by date debut event
//    void sendNotificationToUsersOfAnEventByDateDebutEvent(String type, Long idEvenement, String date);
//    //send notification to users of an event by date fin event
//    void sendNotificationToUsersOfAnEventByDateFinEvent(String type, Long idEvenement, String date);
//    //send notification to users of an activity by date fin activity
//    void sendNotificationToUsersOfAnActivityByDateFinActivity(String type, Long idActivite, String date);
}
