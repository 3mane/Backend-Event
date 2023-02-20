package org.sid.backend.dao;

import org.sid.backend.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, String> {
    Notification findByName(String s);

    //Query find by activite id

  //  @Query("select n from Notification n where n.activite.id = ?1")
    List<Notification> findByActiviteId(String valueOf);



   // List<Notification> findByActiviteId(String valueOf);
    //find by user id
    //List<Notification> findAllByUsers_Id(Long id);



//    List<Notification> findByUserNotification(String username);
    //find by id
    //List<Notification> findByIdNotification(Long id);
//    List<Notification> findByConfirmed(boolean confirmed);
//    List<Notification> findByConfirmedAndIdUser(boolean confirmed, String idUser);
//    List<Notification> findByConfirmedAndIdUserAndType(boolean confirmed, String idUser, String type);
//
//    List<Notification> findByActiviteNotification(String valueOf);
//
//    List<Notification> findByEvenementNotification(String valueOf);
//
//    List<Notification> findByTypeNotification(String type);
//
//    List<Notification> findByConfirmedNotification(boolean confirmed);
//
//    List<Notification> findByDateNotification(String date);
//    List<Notification> findByConfirmedAndIdUserAndTypeAndIdActivite(boolean confirmed, String idUser, String type, String idActivite);
//    List<Notification> findByConfirmedAndIdUserAndTypeAndIdEvenement(boolean confirmed, String idUser, String type, String idEvenement);
}

