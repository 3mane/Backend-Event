package org.sid.backend.services;
import org.sid.backend.domaine.EvenementVo;
import java.util.List;
public interface EvenementService {
    List<EvenementVo> getAllEvenements();
    EvenementVo getEvenementById(Long id);
    EvenementVo saveEvenement(EvenementVo evenementVo);
    EvenementVo updateEvenement(EvenementVo evenementVo);
    void deleteEvenement(Long id);
    //pagination
    List<EvenementVo> getAllEvenementsParPage(int page, int size);
    //find by name
    List<EvenementVo> findByNomEvenement(String nom);
    //find by activity
    List<EvenementVo> findByActiviteEvenement(String activite);
}
