package org.sid.backend.domaine;

import lombok.*;
import org.sid.backend.model.Activite;

import java.util.Date;
import java.util.List;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EvenementVo  {
    private Long id;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String lieu;
    private List<Activite> activites;


}
