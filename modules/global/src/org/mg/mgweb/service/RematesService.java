package org.mg.mgweb.service;

import org.mg.mgweb.entity.TblEntidades;
import org.mg.mgweb.entity.TblEventos;

import java.util.List;

public interface RematesService {
    String NAME = "mgweb_RematesService";

    List<TblEntidades> getEntidadesConSaldo(TblEventos evento);

    Long getPagosTotal(TblEventos evento, TblEntidades entidad);

    Long getPagosAnteriores(TblEventos evento, TblEntidades entidad);

    String getFechasCuotas(TblEventos evento);

}