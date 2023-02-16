package org.sid.backend.services;
import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.model.Activite;

import java.util.List;
public interface ActiviteService {
    List<ActiviteVo> getAllActivites();
    ActiviteVo getActiviteById(Long id);
    //get activite by id evenement
   // List<ActiviteVo> getActiviteByIdEvenement(String id);

    //List<ActiviteVo> getActiviteByIdEvenement(Long id);

    List<ActiviteVo> getActiviteByIdEvenement(Long id);

    void saveActivite(ActiviteVo activiteVo);
    ActiviteVo updateActivite(ActiviteVo activiteVo);
    void deleteActivite(Long id);
    //add user to activite
    void addUserToActivite(String nameActivite , String nameUser);
    //pagination
    List<ActiviteVo> getAllActivitesParPage(int page, int size);
    //find by name
    Activite findByName(String name);
    //find by category
//    List<ActiviteVo> findByCategorieActivite(String categorie);

}
