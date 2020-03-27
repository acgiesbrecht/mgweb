package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.Date;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_entidades_historico_categorias")
@Entity(name = "mgweb_TblEntidadesHistoricoCategorias")
public class TblEntidadesHistoricoCategorias extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 3671926570206114236L;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha")
    protected Date fecha;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categoria_de_pago")
    protected TblMiembrosCategoriasDePago idCategoriaDePago;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entidad")
    protected TblEntidades idEntidad;
    @Column(name = "observaciones")
    protected String observaciones;

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public TblEntidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(TblEntidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    public TblMiembrosCategoriasDePago getIdCategoriaDePago() {
        return idCategoriaDePago;
    }

    public void setIdCategoriaDePago(TblMiembrosCategoriasDePago idCategoriaDePago) {
        this.idCategoriaDePago = idCategoriaDePago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}