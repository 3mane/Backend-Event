package org.sid.backend.model;
import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.backend.sec.entities.AppUser;

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
    	@ManyToMany( fetch=FetchType.LAZY,cascade=CascadeType.ALL )
	@JoinTable(name="notifications_users",joinColumns= {@JoinColumn(name="notifications_id")},inverseJoinColumns= {@JoinColumn(name="users_id")})
	//Set lfr9 binha w bin tab 3adi anaho maymknch ykono fiha des doublons
	private Set<AppUser> users =new HashSet<>();
    @ManyToOne
    @JoinColumn(name="activite_id")
    private Activite activite;
}