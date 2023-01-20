package org.sid.backend.controllers;
import lombok.Data;
import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.domaine.EvenementVo;
import org.sid.backend.model.Evenement;
import org.sid.backend.sec.web.AccountRestController;
import org.sid.backend.services.EvenementService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
public class EvenementRestController {
    @Autowired
    private EvenementService evenementService;
    @PostAuthorize("hasAuthority('ADMIN')")
    @GetMapping(value = "/evenements")
    public List<EvenementVo> getAllEvenements() {
        return evenementService.getAllEvenements();
    }
    @GetMapping(value = "/evenements/{id}")
    public ResponseEntity<Object> getEvenementById(@PathVariable(value = "id") Long evenementVoId) {
        EvenementVo evenementVoFound= evenementService.getEvenementById(evenementVoId);
        if (evenementVoFound == null) {
            return new ResponseEntity<>("Evenement not found", HttpStatus.OK);
        }
        return new ResponseEntity<>(evenementVoFound , HttpStatus.OK);
    }


    @PostAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/evenements")
    public ResponseEntity<Object> saveEvenement(@Valid @RequestBody EvenementVo evenementVo) {
        evenementService.saveEvenement(evenementVo);
        return new ResponseEntity<>("Evenement created successfully", HttpStatus.CREATED);
    }

    //add activite to evenement
    @PostMapping(value = "/evenements/{id}/activites")
    public ResponseEntity<Object> addActiviteToEvenement(@PathVariable(value = "id") Long evenementVoId, @Valid @RequestBody ActiviteVo activiteVo) {

        EvenementVo evenementVoFound= evenementService.getEvenementById(evenementVoId);
        if (evenementVoFound == null) {
            return new ResponseEntity<>("Evenement not found", HttpStatus.OK);
        }
        evenementService.addActiviteToEvenement(evenementVoId, activiteVo);
        return new ResponseEntity<>("Activite added successfully", HttpStatus.CREATED);
    }

    //add event

    /*
    *  public void addRoleToUser(@RequestBody RoleUserForm roleUserForm){
        accountService.addRoleToUser(roleUserForm.getUsername(),roleUserForm.getRoleName());
    }*/
//
//    @PutMapping(value = "/evenements/{id}")
//    public  ResponseEntity<Object> updateEvenement(@PathVariable(value = "id") Long evenementVoId,
//                                                  @Valid @RequestBody EvenementVo evenementVo) {
//        EvenementVo evenementVoFound= evenementService.getEvenementById(evenementVoId);
//        if (evenementVoFound == null) {
//            return new ResponseEntity<>("Evenement not found", HttpStatus.OK);
//        }
//        evenementVo.setId(evenementVoId);
//        evenementVo.setDateDebut(evenementVoFound.getDateDebut());
//        evenementVo.setDateFin(evenementVoFound.getDateFin());
//        evenementVo.setDescription(evenementVoFound.getDescription());
//        evenementVo.setName(evenementVoFound.getName());
//        evenementVo.setActivites(evenementVoFound.getActivites());
//        evenementService.saveEvenement(evenementVo);
//        return new ResponseEntity<>("Evenement updated successfully", HttpStatus.OK);
//    }
//    @DeleteMapping(value = "/evenements/{id}")
//    public ResponseEntity<Object> deleteEvenement(@PathVariable(value = "id") Long evenementVoId) {
//        EvenementVo evenementVoFound= evenementService.getEvenementById(evenementVoId);
//        if (evenementVoFound == null) {
//            return new ResponseEntity<>("Evenement not found", HttpStatus.OK);
//        }
//        evenementService.deleteEvenement(evenementVoId);
//        return new ResponseEntity<>("Evenement deleted successfully", HttpStatus.OK);
//    }
//
//    @GetMapping(value = "/evenements/page")
//    public List<EvenementVo> getAllEvenementsParPage(@RequestParam(name = "page", defaultValue = "0") int page,
//                                                     @RequestParam(name = "size", defaultValue = "5") int size) {
//        return evenementService.getAllEvenementsParPage(page, size);
//    }
//    @GetMapping(value = "/evenements/nom")
//    public List<EvenementVo> findByNomEvenement(@RequestParam(name = "nom", defaultValue = "") String nom) {
//        return evenementService.findByName(nom);
//    }

//    @Data
//    static class EventActForm{
//        private Long idEvenement;
//        private Long idActivite;
//    }
}




