package org.sid.backend.domaine.converter;

import org.sid.backend.domaine.NotificationVo;
import org.sid.backend.model.Notification;

import java.util.ArrayList;
import java.util.List;

public class NotificationConverter {

    public static NotificationVo toVo(Notification notification) {
        NotificationVo notificationVo = new NotificationVo();
        notificationVo.setId(notification.getId());
        notificationVo.setIdUser(notification.getIdUser());
        notificationVo.setIdActivite(notification.getIdActivite());
        notificationVo.setIdEvenement(notification.getIdEvenement());
        notificationVo.setType(notification.getType());
        notificationVo.setDate(notification.getDate());
        notificationVo.setConfirmed(notification.isConfirmed());
        notificationVo.setUsers(notification.getUsers());
        notificationVo.setActivite(notification.getActivite());
        return notificationVo;
    }

    public static Notification toBo(NotificationVo notificationVo) {
        Notification notification = new Notification();
        notification.setId(notificationVo.getId());
        notification.setIdUser(notificationVo.getIdUser());
        notification.setIdActivite(notificationVo.getIdActivite());
        notification.setIdEvenement(notificationVo.getIdEvenement());
        notification.setType(notificationVo.getType());
        notification.setDate(notificationVo.getDate());
        notification.setConfirmed(notificationVo.isConfirmed());
        notification.setUsers(notificationVo.getUsers());
        notification.setActivite(notificationVo.getActivite());
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
