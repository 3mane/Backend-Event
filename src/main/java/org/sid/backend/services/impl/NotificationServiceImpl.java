package org.sid.backend.services.impl;

import org.sid.backend.domaine.NotificationVo;
import org.sid.backend.services.NotificationService;

import java.util.List;

public class NotificationServiceImpl implements NotificationService {

    @Override
    public List<NotificationVo> getAllNotifications() {
        return null;
    }

    @Override
    public NotificationVo getNotificationById(Long id) {
        return null;
    }

    @Override
    public NotificationVo saveNotification(NotificationVo notificationVo) {
        return null;
    }

    @Override
    public NotificationVo updateNotification(NotificationVo notificationVo) {
        return null;
    }

    @Override
    public void deleteNotification(Long id) {

    }

    @Override
    public List<NotificationVo> findByUserNotification(Long idUser) {
        return null;
    }

    @Override
    public List<NotificationVo> findByActiviteNotification(Long idActivite) {
        return null;
    }

    @Override
    public List<NotificationVo> findByEvenementNotification(Long idEvenement) {
        return null;
    }

    @Override
    public List<NotificationVo> findByTypeNotification(String type) {
        return null;
    }

    @Override
    public List<NotificationVo> findByConfirmedNotification(boolean confirmed) {
        return null;
    }

    @Override
    public List<NotificationVo> findByDateNotification(String date) {
        return null;
    }

    @Override
    public void sendNotificationToUser(Long idUser, String type, Long idActivite, Long idEvenement) {

    }

    @Override
    public void sendNotificationToAllUsers(String type, Long idActivite, Long idEvenement) {

    }

    @Override
    public void sendNotificationToAllUsersOfAnActivity(String type, Long idActivite) {

    }

    @Override
    public void sendNotificationToAllUsersOfAnEvent(String type, Long idEvenement) {

    }

    @Override
    public void sendNotificationToAllUsersOfAnActivityAndAnEvent(String type, Long idActivite, Long idEvenement) {

    }

    @Override
    public void sendNotificationToAllUsersOfAnActivityOrAnEvent(String type, Long idActivite, Long idEvenement) {

    }

    @Override
    public void sendNotificationToUsersOfAnActivityByDateDebutActivity(String type, Long idActivite, String date) {

    }

    @Override
    public void sendNotificationToUsersOfAnEventByDateDebutEvent(String type, Long idEvenement, String date) {

    }

    @Override
    public void sendNotificationToUsersOfAnEventByDateFinEvent(String type, Long idEvenement, String date) {

    }

    @Override
    public void sendNotificationToUsersOfAnActivityByDateFinActivity(String type, Long idActivite, String date) {

    }
}
