package org.sid.backend.services.impl;
import org.sid.backend.dao.NotificationRepository;
import org.sid.backend.domaine.NotificationVo;
import org.sid.backend.domaine.converter.NotificationConverter;
import org.sid.backend.model.Notification;
import org.sid.backend.services.NotificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class NotificationServiceImpl implements NotificationService {

    @Autowired
    private NotificationRepository notificationRepository;

    @Override
    public List<NotificationVo> getAllNotifications() {
        List<Notification> notification = notificationRepository.findAll();
        return NotificationConverter.toVo(notification);
    }

    @Override
    public NotificationVo getNotificationById(Long id) {
          Notification notification = notificationRepository.findById(String.valueOf(id)).get();
          return NotificationConverter.toVo(notification);

    }

    @Override
    public void saveNotification(NotificationVo notificationVo) {
        notificationRepository.save(NotificationConverter.toBo(notificationVo));
    }

    @Override
    public NotificationVo updateNotification(NotificationVo notificationVo) {
        //update notification
        Notification notification = NotificationConverter.toBo(notificationVo);
        notificationRepository.save(notification);
        return NotificationConverter.toVo(notification);
    }

    @Override
    public void deleteNotification(Long id) {
        notificationRepository.deleteById(String.valueOf(id));
    }
//
//    @Override
//    public List<NotificationVo> findByUserNotification(Long idUser) {
//        List<Notification> notification = notificationRepository.findByUserNotification(String.valueOf(idUser));
//        return NotificationConverter.toVo(notification);
//    }
//
//    @Override
//    public List<NotificationVo> findByActiviteNotification(Long idActivite) {
//        List<Notification> notification = notificationRepository.findByActiviteNotification(String.valueOf(idActivite));
//        return NotificationConverter.toVo(notification);
//    }
//
//    @Override
//    public List<NotificationVo> findByEvenementNotification(Long idEvenement) {
//        List<Notification> notification = notificationRepository.findByEvenementNotification(String.valueOf(idEvenement));
//        return NotificationConverter.toVo(notification);
//    }
//
////    @Override
////    public List<NotificationVo> findByTypeNotification(String type) {
////        List<Notification> notification = notificationRepository.findByTypeNotification(type);
////        return NotificationConverter.toVo(notification);
////    }
//
//    @Override
//    public List<NotificationVo> findByConfirmedNotification(boolean confirmed) {
//        List<Notification> notification = notificationRepository.findByConfirmedNotification(confirmed);
//        return NotificationConverter.toVo(notification);
//    }
//
//    @Override
//    public List<NotificationVo> findByDateNotification(String date) {
//        List<Notification> notification = notificationRepository.findByDateNotification(date);
//        return NotificationConverter.toVo(notification);
//    }
//
//    @Override
//    public void sendNotificationToUser(Long idUser, String type, Long idActivite, Long idEvenement) {
//        Notification notification = new Notification();
//        notification.setIdUser(String.valueOf(idUser));
//        notification.setType(type);
//        notification.setIdActivite(String.valueOf(idActivite));
//        notification.setIdEvenement(String.valueOf(idEvenement));
//        notification.setConfirmed(false);
//        notificationRepository.save(notification);
//
//    }
//
//    @Override
//    public void sendNotificationToAllUsers(String type, Long idActivite, Long idEvenement) {
//        List<NotificationVo> notificationVos = findByConfirmedNotification(false);
//        for (NotificationVo notificationVo : notificationVos) {
//            sendNotificationToUser(Long.valueOf(notificationVo.getIdUser()), type, idActivite, idEvenement);
//        }
//
//
//    }
//
//    @Override
//    public void sendNotificationToAllUsersOfAnActivity(String type, Long idActivite) {
//        List<NotificationVo> notificationVos = findByConfirmedNotification(false);
//        for (NotificationVo notificationVo : notificationVos) {
//            sendNotificationToUser(Long.valueOf(notificationVo.getIdUser()), type, idActivite, null);
//        }
//
//    }
//
//    @Override
//    public void sendNotificationToAllUsersOfAnEvent(String type, Long idEvenement) {
//        List<NotificationVo> notificationVos = findByConfirmedNotification(false);
//        for (NotificationVo notificationVo : notificationVos) {
//            sendNotificationToUser(Long.valueOf(notificationVo.getIdUser()), type, null, idEvenement);
//        }


//    }

//    @Override
//    public void sendNotificationToAllUsersOfAnActivityAndAnEvent(String type, Long idActivite, Long idEvenement) {
//        List<NotificationVo> notificationVos = findByConfirmedNotification(false);
//        for (NotificationVo notificationVo : notificationVos) {
//            sendNotificationToUser(Long.valueOf(notificationVo.getIdUser()), type, idActivite, idEvenement);
//        }
//
//
//    }
//
//    @Override
//    public void sendNotificationToAllUsersOfAnActivityOrAnEvent(String type, Long idActivite, Long idEvenement) {
//        List<NotificationVo> notificationVos = findByConfirmedNotification(false);
//        for (NotificationVo notificationVo : notificationVos) {
//            sendNotificationToUser(Long.valueOf(notificationVo.getIdUser()), type, idActivite, idEvenement);
//        }
//
//    }

//    @Override
//    public void sendNotificationToUsersOfAnActivityByDateDebutActivity(String type, Long idActivite, String date) {
//        List<NotificationVo> notificationVos = findByConfirmedNotification(false);
//        for (NotificationVo notificationVo : notificationVos) {
//            sendNotificationToUser(Long.valueOf(notificationVo.getIdUser()), type, idActivite, null);
//        }
//
//
//    }
//
//    @Override
//    public void sendNotificationToUsersOfAnEventByDateDebutEvent(String type, Long idEvenement, String date) {
//        List<NotificationVo> notificationVos = findByConfirmedNotification(false);
//        for (NotificationVo notificationVo : notificationVos) {
//            sendNotificationToUser(Long.valueOf(notificationVo.getIdUser()), type, null, idEvenement);
//        }
//
//
//    }
//
//    @Override
//    public void sendNotificationToUsersOfAnEventByDateFinEvent(String type, Long idEvenement, String date) {
//        List<NotificationVo> notificationVos = findByConfirmedNotification(false);
//        for (NotificationVo notificationVo : notificationVos) {
//            sendNotificationToUser(Long.valueOf(notificationVo.getIdUser()), type, null, idEvenement);
//        }
//
//    }
//
//    @Override
//    public void sendNotificationToUsersOfAnActivityByDateFinActivity(String type, Long idActivite, String date) {
//        List<NotificationVo> notificationVos = findByConfirmedNotification(false);
//        for (NotificationVo notificationVo : notificationVos) {
//            sendNotificationToUser(Long.valueOf(notificationVo.getIdUser()), type, idActivite, null);
//        }
//
//
//    }
}
