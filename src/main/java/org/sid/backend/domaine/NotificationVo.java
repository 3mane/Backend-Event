package org.sid.backend.domaine;

import lombok.*;
import org.sid.backend.model.Activite;
import org.sid.backend.sec.entities.AppUser;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NotificationVo {
    private String id;
    private String idUser;
   // private String idActivite;
   // private String idEvenement;
    private String type;
    private Date date;
    private boolean confirmed;
    private Set<AppUser> usersVo =new HashSet<>();
    private ActiviteVo activite;
}
