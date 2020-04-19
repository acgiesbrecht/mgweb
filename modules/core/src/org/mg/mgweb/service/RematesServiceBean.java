package org.mg.mgweb.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.Transaction;
import com.haulmont.cuba.core.global.DataManager;
import org.mg.mgweb.entity.TblEntidades;
import org.mg.mgweb.entity.TblEventoCuotas;
import org.mg.mgweb.entity.TblEventos;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

@Service(RematesService.NAME)
public class RematesServiceBean implements RematesService {


    @Inject
    private Persistence persistence;
    @Inject
    private DataManager dataManager;

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

    public Long getPagosTotal(TblEventos evento, TblEntidades entidad) {
        return dataManager.loadValue("select sum(e.monto) from mgweb_TblEventoDetalle e where e.idEvento = :evento " +
                " and e.idEntidad = :entidad", Long.class)
                .parameter("evento", evento)
                .parameter("entidad", entidad)
                .one();
    }

    public Long getPagosAnteriores(TblEventos evento, TblEntidades entidad) {
        Long importeTransferencias = dataManager.loadValue("select sum(e.montoAporte + e.montoDonacion) from mgweb_TblTransferencias e " +
                " where e.idEvento = :evento " +
                " and e.idEntidad = :entidad", Long.class)
                .parameter("evento", evento)
                .parameter("entidad", entidad)
                .one();
        Long importeRecibos = dataManager.loadValue("select sum(e.montoAporte + e.montoDonacion) from mgweb_TblRecibos e " +
                " where e.idEvento = :evento " +
                " and e.idEntidad = :entidad", Long.class)
                .parameter("evento", evento)
                .parameter("entidad", entidad)
                .one();
        return (importeTransferencias == null ? 0 : importeTransferencias) + (importeRecibos == null ? 0 : importeRecibos);
    }

    public String getFechasCuotas(TblEventos evento) {
        TblEventoCuotas cuotas = dataManager.load(TblEventoCuotas.class).query("select e from mgweb_TblEventoCuotas e " +
                "where e.id = :eventoId" )
                .parameter("eventoId", evento.getId().get())
                .one();

        return cuotas.getFecha1() != null ? cuotas.getFecha1().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))  : ""
                + cuotas.getFecha2() != null ? ", " + cuotas.getFecha1().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : ""
                + cuotas.getFecha3() != null ? ", " + cuotas.getFecha1().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : ""
                + cuotas.getFecha4() != null ? ", " + cuotas.getFecha1().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) : "";
    }

}