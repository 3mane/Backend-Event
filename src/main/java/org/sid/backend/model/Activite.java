package org.sid.backend.model;
import java.io.Serializable;
import java.util.*;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @ManyToMany( fetch=FetchType.EAGER,cascade=CascadeType.ALL )
    @JoinTable(name="activites_users",joinColumns= {@JoinColumn(name="activites_id")},inverseJoinColumns= {@JoinColumn(name="users_id")})
    @JsonIgnore
    //Set lfr9 binha w bin tab 3adi anaho maymknch ykono fiha des doublons
    //private Set<AppUser> users =new HashSet<>();
    private Collection<AppUser> users =new ArrayList<>();

    @OneToMany(mappedBy= "activite",cascade= CascadeType.ALL)
    //@JsonIgnore
    private List<Notification> notifications;
}