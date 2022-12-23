package org.sid.backend.services.impl;

import org.sid.backend.domaine.EvenementVo;
import org.sid.backend.services.EvenementService;

import java.util.List;

public class EvenementServiceImpl implements EvenementService {

    @Override
    public List<EvenementVo> getAllEvenements() {
        return null;
    }

    @Override
    public EvenementVo getEvenementById(Long id) {
        return null;
    }

    @Override
    public EvenementVo saveEvenement(EvenementVo evenementVo) {
        return null;
    }

    @Override
    public EvenementVo updateEvenement(EvenementVo evenementVo) {
        return null;
    }

    @Override
    public void deleteEvenement(Long id) {

    }

    @Override
    public List<EvenementVo> getAllEvenementsParPage(int page, int size) {
        return null;
    }

    @Override
    public List<EvenementVo> findByNomEvenement(String nom) {
        return null;
    }

    @Override
    public List<EvenementVo> findByActiviteEvenement(String activite) {
        return null;
    }

}
