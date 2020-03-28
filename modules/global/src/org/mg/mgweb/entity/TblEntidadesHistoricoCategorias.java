package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

@NamePattern("%s %s %s|idEntidad,idCategoriaDePago,fecha")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_entidades_historico_categorias")
@Entity(name = "mgweb_TblEntidadesHistoricoCategorias")
public class TblEntidadesHistoricoCategorias extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 3671926570206114236L;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha")
    protected LocalDateTime fecha;

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

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }
}