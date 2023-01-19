package org.sid.backend.domaine.converter;
import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.domaine.EvenementVo;
import org.sid.backend.model.Activite;
import org.sid.backend.model.Evenement;

import java.util.ArrayList;
import java.util.List;

public class EvenementConverter {
public static EvenementVo toVo(Evenement evenement) {
         EvenementVo evenementVo = new EvenementVo();
          evenementVo.setId(evenement.getId());
          evenementVo.setName(evenement.getName());
          evenementVo.setDescription(evenement.getDescription());
          evenementVo.setDateDebut(evenement.getDateDebut());
          evenementVo.setDateFin(evenement.getDateFin());
          evenementVo.setLieu(evenement.getLieu());

          //  evenementVo.setActivites(ActiviteConverter.toVo(evenement.getActivites()));
         evenementVo.setActivites(evenement.getActivites());




          return evenementVo;
}
public static Evenement toBo(EvenementVo evenementVo) {
          Evenement evenement = new Evenement();
          evenement.setId(evenementVo.getId());
          evenement.setName(evenementVo.getName());
          evenement.setDescription(evenementVo.getDescription());
          evenement.setDateDebut(evenementVo.getDateDebut());
          evenement.setDateFin(evenementVo.getDateFin());
          evenement.setLieu(evenementVo.getLieu());
           // evenement.setActivites((List<Activite>) ActiviteConverter.toBo((ActiviteVo) evenementVo.getActivites()));
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
