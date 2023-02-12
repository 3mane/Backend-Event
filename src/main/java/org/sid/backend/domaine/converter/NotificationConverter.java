package org.sid.backend.domaine.converter;

import org.sid.backend.domaine.NotificationVo;
import org.sid.backend.model.Notification;
import org.sid.backend.sec.entities.AppUser;

import java.util.ArrayList;
import java.util.List;

public class NotificationConverter {

    public static NotificationVo toVo(Notification notification) {
        NotificationVo notificationVo = new NotificationVo();
        notificationVo.setId(notification.getId());
        notificationVo.setType(notification.getType());
        notificationVo.setDate(notification.getDate());
        notificationVo.setConfirmed(notification.isConfirmed());
               for (AppUser user : notification.getUsers()) {
                    notificationVo.getUsersVo().add(user);
                }
                return notificationVo;
    }

    public static Notification toBo(NotificationVo notificationVo) {
        Notification notification = new Notification();
        notification.setId(notificationVo.getId());
        notification.setType(notificationVo.getType());
        notification.setDate(notificationVo.getDate());
        notification.setConfirmed(notificationVo.isConfirmed());
        for (AppUser user : notificationVo.getUsersVo()) {
            notification.getUsers().add(user);
        }

        return notification;
    }

    public static List<NotificationVo> toVo(List<Notification> notifications) {
        List<NotificationVo> notificationVos = new ArrayList<>();
        for (Notification notification : notifications) {
            notificationVos.add(toVo(notification));
        }
        return notificationVos;
    }

}
