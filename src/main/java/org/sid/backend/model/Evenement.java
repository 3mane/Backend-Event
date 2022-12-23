package org.sid.backend.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evenement implements Serializable {
    private static final long serialVersionUID = 5448552240001397099L;
    @Id
    @GeneratedValue
    private Long id;
    private String nom;
    private String description;
    private Date dateDebut;
    private Date dateFin;
    private String lieu;
    @OneToMany(mappedBy= "evenement",cascade= CascadeType.ALL)
    private List<Activite> activites;
}