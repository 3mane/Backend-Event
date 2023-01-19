package org.sid.backend.controllers;
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

    @GetMapping(value = "/activites/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
   public ResponseEntity<Object> getActiviteById(@PathVariable(value = "id") Long activiteVoId) {
        ActiviteVo activiteVoFound= activiteService.getActiviteById(activiteVoId);
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


    @PutMapping(value = "/activites/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public  ResponseEntity<Object> updateActivite(@PathVariable(value = "id") Long activiteVoId,
                                                  @Valid @RequestBody ActiviteVo activiteVo) {
        ActiviteVo activiteVoFound= activiteService.getActiviteById(activiteVoId);
        if (activiteVoFound == null) {
            return new ResponseEntity<>("Activite not found", HttpStatus.OK);
        }
        activiteVo.setId(activiteVoId);
        activiteVo.setDateDebut(activiteVoFound.getDateDebut());
        activiteVo.setDateFin(activiteVoFound.getDateFin());
        activiteVo.setDescription(activiteVoFound.getDescription());
        activiteVo.setEvenement(activiteVoFound.getEvenement());
        activiteVo.setName(activiteVoFound.getName());
    //....
        activiteService.saveActivite(activiteVo);
        return new ResponseEntity<>("Activite updated successfully", HttpStatus.OK);
    }
    @DeleteMapping(value = "/activites/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<Object> deleteActivite(@PathVariable(value = "id") Long activiteVoId) {
        ActiviteVo activiteVoFound= activiteService.getActiviteById(activiteVoId);
        if (activiteVoFound == null) {
            return new ResponseEntity<>("Activite not found", HttpStatus.OK);
        }
        activiteService.deleteActivite(activiteVoId);
        return new ResponseEntity<>("Activite deleted successfully", HttpStatus.OK);
    }
    //pagination
    @GetMapping(value = "/activites/page/{page}/size/{size}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<ActiviteVo> getAllActivitesParPage(@PathVariable(value = "page") int page,
                                                   @PathVariable(value = "size") int size) {
        return activiteService.getAllActivitesParPage(page, size);
    }
    //find by name
    @GetMapping(value = "/activites/nom/{nom}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public List<ActiviteVo> findByActiviteName(@PathVariable(value = "nom") String nom) {
        return activiteService.findByName(nom);
    }
}
