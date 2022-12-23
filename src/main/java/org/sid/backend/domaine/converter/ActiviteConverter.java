package org.sid.backend.domaine.converter;

import org.sid.backend.domaine.ActiviteVo;
import org.sid.backend.model.Activite;

import java.util.ArrayList;
import java.util.List;

public class ActiviteConverter {
public static ActiviteVo toVo(Activite activite) {
    ActiviteVo activiteVo = new ActiviteVo();
    activiteVo.setId(activite.getId());
    activiteVo.setNom(activite.getNom());
    activiteVo.setDescription(activite.getDescription());
    activiteVo.setDateDebut(activite.getDateDebut());
    activiteVo.setDateFin(activite.getDateFin());
    activiteVo.setLieu(activite.getLieu());
    activiteVo.setEvenement(activite.getEvenement());
    return activiteVo;
}
public static Activite toBo(ActiviteVo activiteVo) {
    Activite activite = new Activite();
    activite.setId(activiteVo.getId());
    activite.setNom(activiteVo.getNom());
    activite.setDescription(activiteVo.getDescription());
    activite.setDateDebut(activiteVo.getDateDebut());
    activite.setDateFin(activiteVo.getDateFin());
    activite.setLieu(activiteVo.getLieu());
    activite.setEvenement(activiteVo.getEvenement());
    return activite;
}
public static List<ActiviteVo> toVo(List<Activite> activites) {
    List<ActiviteVo> activiteVos = new ArrayList<>();
    for (Activite activite : activites) {
        activiteVos.add(toVo(activite));
    }
    return activiteVos;
}

}
