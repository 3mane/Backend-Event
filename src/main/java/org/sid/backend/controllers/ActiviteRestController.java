package org.sid.backend.controllers;
import lombok.Data;
import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.services.ActiviteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
@RestController
public class ActiviteRestController {
@Autowired
private ActiviteService activiteService;
//@RequestMapping("/activites")
    @GetMapping(value = "/activites", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PostAuthorize("hasAuthority('USER')")
    public List<ActiviteVo> getAllActivites() {
    return activiteService.getAllActivites();
    }


    @GetMapping(value = "/activite/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
   public ResponseEntity<Object> getActiviteById(@PathVariable(value = "id") String activiteVoId) {
        ActiviteVo activiteVoFound= activiteService.getActiviteById(Long.valueOf(activiteVoId));
        if (activiteVoFound == null) {
            return new ResponseEntity<>("Activite not found", HttpStatus.OK);
        }
        return new ResponseEntity<>(activiteVoFound , HttpStatus.OK);
    }


    @PostAuthorize("hasAuthority('ADMIN')")
    @PostMapping(value = "/activites", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> saveActivite(@Valid @RequestBody ActiviteVo activiteVo) {
        activiteService.saveActivite(activiteVo);
        return new ResponseEntity<>("Activite created successfully", HttpStatus.CREATED);
    }
    //add user to activite

      @PostMapping(path ="/addUserToActivite")
        @PostAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")

        public void addUserToActivite(@RequestBody UserActiviteForm userActiviteForm){
            activiteService.addUserToActivite(userActiviteForm.getNameActivite(),userActiviteForm.getNameUser());
        }

    //get activite by id evenement
    @GetMapping(value = "/activites/evenement/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PostAuthorize("hasAuthority('ADMIN') or hasAuthority('USER')")
    public List<ActiviteVo> getActiviteByIdEvenement(@PathVariable(value = "id") String evenementVoId) {
        return activiteService.getActiviteByIdEvenement(Long.valueOf(evenementVoId));
    }

    //update activite
    @PutMapping(value = "/activites/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PostAuthorize("hasAuthority('ADMIN') ")
    public ResponseEntity<Object> updateActivite(@PathVariable(value = "id") String activiteVoId, @Valid @RequestBody ActiviteVo activiteVo) {
        ActiviteVo activiteVoFound= activiteService.getActiviteById(Long.valueOf(activiteVoId));
        if (activiteVoFound == null) {
            return new ResponseEntity<>("Activite not found", HttpStatus.OK);
        }
        activiteService.updateActivite(activiteVo);
        return new ResponseEntity<>("Activite updated successfully", HttpStatus.OK);
    }
    //delete activite
    @DeleteMapping(value = "/activites/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @PostAuthorize("hasAuthority('ADMIN') ")
    public ResponseEntity<Object> deleteActivite(@PathVariable(value = "id") String activiteVoId) {
        ActiviteVo activiteVoFound= activiteService.getActiviteById(Long.valueOf(activiteVoId));
        if (activiteVoFound == null) {
            return new ResponseEntity<>("Activite not found", HttpStatus.OK);
        }
        activiteService.deleteActivite(Long.valueOf(activiteVoId));
        return new ResponseEntity<>("Activite deleted successfully", HttpStatus.OK);
    }


    @Data
    static class UserActiviteForm{
        private String nameActivite;
        private String nameUser;
    }
}