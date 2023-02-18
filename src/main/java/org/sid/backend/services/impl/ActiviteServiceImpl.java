package org.sid.backend.services.impl;
import org.sid.backend.dao.ActiviteRepository;
import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.domaine.converter.ActiviteConverter;
import org.sid.backend.model.Activite;
import org.sid.backend.model.Notification;
import org.sid.backend.sec.entities.AppUser;
import org.sid.backend.sec.repo.AppUserRepository;
import org.sid.backend.services.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class  ActiviteServiceImpl implements ActiviteService {
    @Autowired
    private ActiviteRepository activiteRepository;
    @Autowired
    private AppUserRepository appUserRepository;

    @Override
    public List<ActiviteVo> getAllActivites() {
        List<Activite> activite = activiteRepository.findAll();
        return ActiviteConverter.toVo(activite);
    }

    @Override
    public ActiviteVo getActiviteById(Long id) {
        Activite activite = activiteRepository.findById(id).get();
        return ActiviteConverter.toVo(activite);

    }

    @Override
    public List<ActiviteVo> getActiviteByIdEvenement(Long id) {
        List<Activite> activite = activiteRepository.findByEvenementId(id);
        return ActiviteConverter.toVo(activite);
    }


    /*
    *     @Override
    public void saveEvenement(EvenementVo evenementVo) {
        Evenement evenement = EvenementConverter.toBo(evenementVo);
        for (Activite activite : evenement.getActivites()) {
            activite.setEvenement(evenement);
        }
        evenementRepository.save(evenement);
    }*/
    @Override
    public void saveActivite(ActiviteVo activiteVo) {
      Activite activite = ActiviteConverter.toBo(activiteVo);
      for (AppUser appUser : activite.getUsers()) {
                appUser.setActivites((List<Activite>) activite);
      }
      //notification
//        for (Notification notification : activite.getNotifications()) {
//            notification.setActivite(activite);
//        }
            activiteRepository.save(activite);
    }

    @Override
    public ActiviteVo updateActivite(ActiviteVo activiteVo) {
       //update activite
        Activite activite = (Activite) ActiviteConverter.toBo(activiteVo);
        activiteRepository.save(activite);
        return ActiviteConverter.toVo(activite);
    }

    @Override
    public void deleteActivite(Long id) {
        activiteRepository.deleteById(id);
    }
///////////////////////////////////////////////////////////////////////////////
    @Override
    public void addUserToActivite(String nameActivity , String nameUser) {
        Activite activite = activiteRepository.findByName(nameActivity);
        AppUser appUser = appUserRepository.findByUsername(nameUser);
        activite.getUsers().add(appUser);
    }
///////////////////////////////////////////////////////////////////////////////

    @Override
    public List<ActiviteVo> getAllActivitesParPage(int page, int size) {
        Page<Activite> activitePage = activiteRepository.findAll(PageRequest.of(page, size,  Sort.Direction.ASC, "name"));
        return ActiviteConverter.toVo(activitePage.getContent());
    }

    @Override
    public Activite findByName(String name) {
        return activiteRepository.findByName(name);
    }


}


