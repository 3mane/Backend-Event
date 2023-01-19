package org.sid.backend.services;
import org.sid.backend.domaine.ActiviteVo;
import java.util.List;
public interface ActiviteService {
    List<ActiviteVo> getAllActivites();
    ActiviteVo getActiviteById(Long id);
    void saveActivite(ActiviteVo activiteVo);
    ActiviteVo updateActivite(ActiviteVo activiteVo);
    void deleteActivite(Long id);
    //pagination
    List<ActiviteVo> getAllActivitesParPage(int page, int size);
    //find by name
    List<ActiviteVo> findByName(String name);
    //find by category
//    List<ActiviteVo> findByCategorieActivite(String categorie);

}
