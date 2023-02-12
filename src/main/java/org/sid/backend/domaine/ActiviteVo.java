package org.sid.backend.domaine;

import lombok.*;
import org.sid.backend.model.Evenement;
import org.sid.backend.model.Notification;
import org.sid.backend.sec.entities.AppUser;

import java.util.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ActiviteVo {
    private Long id;
    private String name;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String lieu;
    private String categorie;
    private EvenementVo evenementVo;
    private List<AppUser> users =new ArrayList<>();
    private List<NotificationVo> notifications=new ArrayList<>();
}
