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

public class Notification implements Serializable {
    private static final long serialVersionUID = 5448552240001397099L;
    @Id
    @GeneratedValue
    private String id;
    private String idUser;
    private String idActivite;
    private String idEvenement;
    private String type;
    private Date date;
    private boolean confirmed;
}
