package org.sid.backend.dao;

import org.sid.backend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, String> {
    List<Notification> findByConfirmed(boolean confirmed);
    List<Notification> findByConfirmedAndIdUser(boolean confirmed, String idUser);
    List<Notification> findByConfirmedAndIdUserAndType(boolean confirmed, String idUser, String type);
//    List<Notification> findByConfirmedAndIdUserAndTypeAndIdActivite(boolean confirmed, String idUser, String type, String idActivite);
//    List<Notification> findByConfirmedAndIdUserAndTypeAndIdEvenement(boolean confirmed, String idUser, String type, String idEvenement);
}

