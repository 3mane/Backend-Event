package org.sid.backend.services.impl;

import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.services.ActiviteService;

import java.util.List;

public class ActiviteServiceImpl implements ActiviteService {

    @Override
    public List<ActiviteVo> getAllActivites() {
        return null;
    }

    @Override
    public ActiviteVo getActiviteById(Long id) {
        return null;
    }

    @Override
    public ActiviteVo saveActivite(ActiviteVo activiteVo) {
        return null;
    }

    @Override
    public ActiviteVo updateActivite(ActiviteVo activiteVo) {
        return null;
    }

    @Override
    public void deleteActivite(Long id) {

    }

    @Override
    public List<ActiviteVo> getAllActivitesParPage(int page, int size) {
        return null;
    }

    @Override
    public List<ActiviteVo> findByNomActivite(String nom) {
        return null;
    }

    @Override
    public List<ActiviteVo> findByCategorieActivite(String categorie) {
        return null;
    }
}


