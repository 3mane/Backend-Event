package org.sid.backend.sec.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppRole  implements Serializable {
 private static final long serialVersionUID = 5448552240001397099L;
 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;
private String roleName;
}
