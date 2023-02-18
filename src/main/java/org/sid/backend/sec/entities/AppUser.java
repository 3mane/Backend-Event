package org.sid.backend.sec.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.backend.model.Activite;
import org.sid.backend.model.Notification;
import javax.persistence.*;
import java.io.Serializable;
import java.util.*;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppUser  implements Serializable {
    private static final long serialVersionUID = 5448552240001397099L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String nom;
    private String prenom;
    private String tel;
    private String adresse;
    private String email;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    //EAGER : pour charger les roles de l'utilisateur
    //@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> appRoles=new ArrayList<>();
    @JsonIgnore
    @ManyToMany( fetch=FetchType.LAZY,cascade=CascadeType.ALL ,mappedBy="users")
    private Set<Notification> notifications = new HashSet<>();
    @ManyToMany( fetch=FetchType.LAZY,cascade=CascadeType.ALL ,mappedBy="users")

    private List<Activite> activites = new ArrayList<>();
}
