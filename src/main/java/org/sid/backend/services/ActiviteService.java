package org.sid.backend.services;
import org.sid.backend.domaine.ActiviteVo;
import java.util.List;
public interface ActiviteService {
    List<ActiviteVo> getAllActivites();
    ActiviteVo getActiviteById(Long id);
    ActiviteVo saveActivite(ActiviteVo activiteVo);
    ActiviteVo updateActivite(ActiviteVo activiteVo);
    void deleteActivite(Long id);
    //pagination
    List<ActiviteVo> getAllActivitesParPage(int page, int size);
    //find by name
    List<ActiviteVo> findByNomActivite(String nom);
    //find by category
    List<ActiviteVo> findByCategorieActivite(String categorie);

}
