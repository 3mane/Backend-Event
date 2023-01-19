package org.sid.backend.services.impl;

import org.sid.backend.dao.ActiviteRepository;
import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.domaine.converter.ActiviteConverter;
import org.sid.backend.model.Activite;
import org.sid.backend.services.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class  ActiviteServiceImpl implements ActiviteService {
    @Autowired
    private ActiviteRepository activiteRepository;

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
    public void saveActivite(ActiviteVo activiteVo) {
        activiteRepository.save(ActiviteConverter.toBo(activiteVo));
    }

    @Override
    public ActiviteVo updateActivite(ActiviteVo activiteVo) {
       //update activite
        Activite activite = ActiviteConverter.toBo(activiteVo);
        activiteRepository.save(activite);
        return ActiviteConverter.toVo(activite);
    }

    @Override
    public void deleteActivite(Long id) {
        activiteRepository.deleteById(id);
    }

    @Override
    public List<ActiviteVo> getAllActivitesParPage(int page, int size) {
        Page<Activite> activitePage = activiteRepository.findAll(PageRequest.of(page, size,  Sort.Direction.ASC, "name"));
        return ActiviteConverter.toVo(activitePage.getContent());
    }

    @Override
    public List<ActiviteVo> findByName(String name) {
        List<Activite> activite = activiteRepository.findByName(name);
        return ActiviteConverter.toVo(activite);
    }

//    @Override
//    public List<ActiviteVo> findByCategorieActivite(String categorie) {
//        List<Activite> activite = activiteRepository.findByCategorieActivite(categorie);
//        return ActiviteConverter.toVo(activite);
//    }
}


