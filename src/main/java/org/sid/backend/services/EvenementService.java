package org.sid.backend.services;
import org.sid.backend.domaine.EvenementVo;

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
    EvenementVo addActiviteToEvenement(Long idEvenement, Long idActivite);
    //add activite to evenement






    //void addActiviteToEvenement(EvenementVo evenementVo);
    //find by activity
//    List<EvenementVo> findByActiviteEvenement(String activite);
}
