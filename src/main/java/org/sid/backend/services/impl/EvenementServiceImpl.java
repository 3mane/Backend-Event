package org.sid.backend.services.impl;
import org.sid.backend.dao.ActiviteRepository;
import org.sid.backend.dao.EvenementRepository;
import org.sid.backend.domaine.EvenementVo;
import org.sid.backend.domaine.converter.EvenementConverter;
import org.sid.backend.model.Activite;
import org.sid.backend.model.Evenement;
import org.sid.backend.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class EvenementServiceImpl implements EvenementService {
    @Autowired
    private EvenementRepository evenementRepository;
    @Autowired
    ActiviteRepository activiteRepository;
    @Override
    public List<EvenementVo> getAllEvenements() {
        List<Evenement> evenement = evenementRepository.findAll();
        return EvenementConverter.toVo(evenement);
    }
    @Override
    public EvenementVo getEvenementById(Long id) {
        Evenement evenement = evenementRepository.findById(id).get();
        return EvenementConverter.toVo(evenement);
    }

    @Override
    public void saveEvenement(EvenementVo evenementVo) {
        evenementRepository.save(EvenementConverter.toBo(evenementVo));
    }


    @Override
    public EvenementVo updateEvenement(EvenementVo evenementVo) {
        //update evenement
        Evenement evenement = EvenementConverter.toBo(evenementVo);
        evenementRepository.save(evenement);
        return EvenementConverter.toVo(evenement);
    }

    @Override
    public void deleteEvenement(Long id) {
        evenementRepository.deleteById(id);
    }

    @Override
    public List<EvenementVo> getAllEvenementsParPage(int page, int size) {
        Page<Evenement> evenementPage = evenementRepository.findAll(PageRequest.of(page, size,  Sort.Direction.ASC, "name"));
        return EvenementConverter.toVo(evenementPage.getContent());
    }

    @Override
    public List<EvenementVo> findByName(String name) {
        List<Evenement> evenement = evenementRepository.findByName(name);
        return EvenementConverter.toVo(evenement);
    }

//    @Override
//    public void addActiviteToEvenement(EvenementVo evenementVo) {
//        
//        
//        Evenement evenement = EvenementConverter.toBo(evenementVo);
//        Activite activite = activiteRepository.findById(evenementVo.getActivites().getId()).get();
//        evenement.setActivites((List<Activite>) activite);
//        evenementRepository.save(evenement);
//    }
    
    //add activite to evenement
    @Override
public EvenementVo addActiviteToEvenement(Long idEvenement, Long idActivite) {
        Evenement evenement = evenementRepository.findById(idEvenement).get();
        Activite activite = activiteRepository.findById(idActivite).get();
        evenement.getActivites().add(activite);
        evenementRepository.save(evenement);
        return EvenementConverter.toVo(evenement);


    }

//    @Override
//    public void addActiviteToEvenement(Long idEvenement, Long idActivite) {
////        Evenement evenement = evenementRepository.findById(idEvenement).get();
////        Activite activite = new Activite();
////        activite.setId(idActivite);
////        evenement.getActivites().add(activite);
////        evenementRepository.save(evenement);
////        return EvenementConverter.toVo(evenement);
//        Evenement evenement = evenementRepository.findById(idEvenement).get();
//        Activite activite = activiteRepository.findById(idActivite).get();
//        evenement.getActivites().add(activite);
//    }
//
//    @Override
//    public List<EvenementVo> findByActiviteEvenement(String activite) {
//        List<Evenement> evenement = evenementRepository.findByActiviteEvenement(activite);
//        return EvenementConverter.toVo(evenement);
//    }

}
