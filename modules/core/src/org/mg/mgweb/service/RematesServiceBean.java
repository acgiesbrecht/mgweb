package org.mg.mgweb.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import org.mg.mgweb.entity.TblEntidades;
import org.mg.mgweb.entity.TblEventos;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@Service(RematesService.NAME)
public class RematesServiceBean implements RematesService {


    @Inject
    private Persistence persistence;

    public List<TblEntidades> getEntidadesConSaldo(TblEventos evento) {
        List<TblEntidades> list = new ArrayList<>();
        try (Transaction tx = persistence.createTransaction()) {
            list = persistence.getEntityManager()
                    .createNativeQuery("SELECT entidades.* FROM TBL_ENTIDADES entidades, " +
                            "                    (SELECT ID FROM (SELECT e.ID, e.CTACTE, SUM(DETALLE.MONTO) AS MONTO FROM" +
                            "                    (SELECT ed.id_entidad," +
                            "                                    SUM(COALESCE(ed.monto,0)) AS monto" +
                            "                                  FROM TBL_EVENTO_DETALLE ed LEFT JOIN TBL_EVENTOS ev ON ed.ID_EVENTO = ev.ID WHERE ev.ID = " + evento.getId().get().toString() +
                            "                                    group by ed.id_entidad" +
                            "                     UNION ALL  " +
                            "                     SELECT p.id_entidad," +
                            "                                     -SUM(COALESCE(p.MONTO_APORTE,0) + COALESCE(p.MONTO_DONACION,0)) AS monto" +
                            "                                     FROM TBL_TRANSFERENCIAS p WHERE p.ID_EVENTO = " + evento.getId().get().toString() +
                            "                                     group by p.id_entidad" +
                            "                     UNION ALL " +
                            "                     SELECT p.id_entidad," +
                            "                            -SUM(COALESCE(p.MONTO_APORTE,0) + COALESCE(p.MONTO_DONACION,0)) AS monto" +
                            "                            FROM TBL_RECIBOS p WHERE p.ID_EVENTO = " + evento.getId().get().toString() +
                            "                            group by p.id_entidad) DETALLE LEFT JOIN TBL_ENTIDADES e ON DETALLE.ID_ENTIDAD = e.ID" +
                            "                     GROUP BY e.ID, e.CTACTE, e.APELLIDOS, e.NOMBRES) d" +
                            "                     WHERE MONTO > 0) e" +
                            "                     WHERE entidades.ID = e.ID" +
                            "                     ORDER BY CTACTE", TblEntidades.class)
                    .getResultList();
            tx.commit();
        }
        return list == null ? null : list;
    }

}