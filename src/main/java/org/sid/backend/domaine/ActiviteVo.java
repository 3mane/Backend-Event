package org.sid.backend.domaine;

import lombok.*;
import org.sid.backend.model.Evenement;
import org.sid.backend.model.Notification;
import org.sid.backend.sec.entities.AppUser;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActiviteVo {
    private Long id;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String lieu;
    private String categorie;
    private Evenement evenement;
    private Set<AppUser> users =new HashSet<>();
    private List<Notification> notifications;


}
