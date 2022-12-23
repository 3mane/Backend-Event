package org.sid.backend.domaine.converter;
import org.sid.backend.domaine.EvenementVo;
import org.sid.backend.model.Evenement;

import java.util.ArrayList;
import java.util.List;

public class EvenementConverter {
public static EvenementVo toVo(Evenement evenement) {
    EvenementVo evenementVo = new EvenementVo();
    evenementVo.setId(evenement.getId());
    evenementVo.setNom(evenement.getNom());
    evenementVo.setDescription(evenement.getDescription());
    evenementVo.setDateDebut(evenement.getDateDebut());
    evenementVo.setDateFin(evenement.getDateFin());
    evenementVo.setLieu(evenement.getLieu());
    evenementVo.setActivites(evenement.getActivites());
    return evenementVo;
}
public static Evenement toBo(Evenement evenementVo) {
    Evenement evenement = new Evenement();
    evenement.setId(evenementVo.getId());
    evenement.setNom(evenementVo.getNom());
    evenement.setDescription(evenementVo.getDescription());
    evenement.setDateDebut(evenementVo.getDateDebut());
    evenement.setDateFin(evenementVo.getDateFin());
    evenement.setLieu(evenementVo.getLieu());
    evenement.setActivites(evenementVo.getActivites());
    return evenement;
}
public static List<EvenementVo> toVo(List<Evenement> evenements) {
    List<EvenementVo> evenementVos = new ArrayList<>();
    for (Evenement evenement : evenements) {
        evenementVos.add(toVo(evenement));
    }
    return evenementVos;
}





}
