package org.sid.backend.dao;
import org.sid.backend.model.Evenement;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface EvenementRepository extends JpaRepository<Evenement, Long> {

    List<Evenement> findByName(String name);
    //find by id



//    List<Evenement> findByActiviteEvenement(String activite);
//    void abonner(Long idEvenement, String username);
//    void desabonner(Long idEvenement, String username);
}
