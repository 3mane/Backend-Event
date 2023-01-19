package org.sid.backend.model;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.backend.sec.entities.AppUser;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Activite  implements Serializable {
    private static final long serialVersionUID = 5448552240001397099L;
    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String description;
    @JsonFormat(pattern="yyyy-MM-dd")

    private Date dateDebut;
    @JsonFormat(pattern="yyyy-MM-dd")

    private Date dateFin;
    private String lieu;
    private String categorie;
    @ManyToOne
    @JoinColumn(name="evenement_id")
    private Evenement evenement;
    @ManyToMany( fetch=FetchType.LAZY,cascade=CascadeType.ALL )
    @JoinTable(name="activites_users",joinColumns= {@JoinColumn(name="activites_id")},inverseJoinColumns= {@JoinColumn(name="users_id")})
    //Set lfr9 binha w bin tab 3adi anaho maymknch ykono fiha des doublons
    private Set<AppUser> users =new HashSet<>();
    @OneToMany(mappedBy= "activite",cascade= CascadeType.ALL)
    private List<Notification> notifications;
}