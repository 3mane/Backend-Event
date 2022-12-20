package org.sid.backend.entities;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
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
    //private Image image;
    private String type;
    private String categorie;
    private String prix;
    //private String organisateur;
    //private String contact;
    private String email;
    private String telephone;
}