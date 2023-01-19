package org.sid.backend.services.impl;

import org.sid.backend.dao.EvenementRepository;
import org.sid.backend.domaine.EvenementVo;
import org.sid.backend.sec.repo.AppUserRepository;
import org.sid.backend.services.AppUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AppUserServiceImpl implements AppUserService {


    @Autowired
    private AppUserRepository appUserRepository;
//    @Autowired
//    private EvenementRepository evenementRepository;
//    @Override
//    public void abonner(Long idEvenement, String username) {
//        appUserRepository.abonner(idEvenement, username);
//
//    }
//
//
//
//    /*public void abonner(Long idEvenement, String username) {
//    // Find the event with the given ID
//    Event event = findEventById(idEvenement);
//
//    // Add the user to the list of subscribers for the event
//    event.addSubscriber(username);
//}*/
//
//    @Override
//    public void desabonner(Long idEvenement, String username) {
//        appUserRepository.desabonner(idEvenement, username);
//    }
//
//    @Override
//    public void inscrire(Long idActivite, String username) {
//        appUserRepository.inscrire(idActivite, username);
//
//    }
//
//    @Override
//    public void desinscrire(Long idActivite, String username) {
//        appUserRepository.desinscrire(idActivite, username);
//    }
//
//    @Override
//    public void desactiverNotification(Long idNotification, String username) {
//        appUserRepository.desactiverNotification(idNotification, username);
//    }
//
//    @Override
//    public void activerNotification(Long idNotification, String username) {
//        appUserRepository.activerNotification(idNotification, username);
//    }
//
//    @Override
//    public void confirmerNotification(Long idNotification, String username) {
//        appUserRepository.confirmerNotification(idNotification, username);
//    }
//
//    @Override
//    public void desconfirmerNotification(Long idNotification, String username) {
//        appUserRepository.desconfirmerNotification(idNotification, username);
//    }


}
