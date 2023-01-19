package org.sid.backend.model;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.sid.backend.domaine.ActiviteVo;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Evenement implements Serializable {
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
    @OneToMany(mappedBy= "evenement",cascade= CascadeType.ALL)
    private List<Activite> activites;


}