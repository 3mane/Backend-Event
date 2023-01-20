package org.sid.backend.services;
import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.domaine.EvenementVo;
import org.sid.backend.model.Evenement;

import java.util.List;
public interface EvenementService {
    List<EvenementVo> getAllEvenements();
    EvenementVo getEvenementById(Long id);
    void saveEvenement(EvenementVo evenementVo);
    //EvenementVo saveEvenement(EvenementVo evenementVo);
    EvenementVo updateEvenement(EvenementVo evenementVo);
    void deleteEvenement(Long id);
    //pagination
    List<EvenementVo> getAllEvenementsParPage(int page, int size);
    //find by name
    List<EvenementVo> findByName(String name);


    //add activite to evenement
    void addActiviteToEvenement(Long idEvenement, ActiviteVo activiteVo);
   //**************************************************************
    //add event
//    Evenement addEvent(EvenementVo evenementVo,List<ActiviteVo> activiteVos);
    //**************************************************************
//    EvenementVo addActiviteToEvenement(Long idEvenement, ActiviteVo activiteVo);

    //find by activity
//    List<EvenementVo> findByActiviteEvenement(String activite);
}
