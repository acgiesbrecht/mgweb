package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

@NamePattern("%s %s|fecha,descripcion")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_eventos")
@Entity(name = "mgweb_TblEventos")
public class TblEventos extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -104719805885893125L;

    @Column(name = "descripcion", length = 100)
    protected String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha", nullable = false)
    protected LocalDateTime fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_centro_de_costo")
    protected TblCentrosDeCosto idCentroDeCosto;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento_tipo")
    protected TblEventoTipos idEventoTipo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_grupo")
    protected org.mg.mgweb.entity.TblGrupos idGrupo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user")
    protected org.mg.mgweb.entity.TblUsers idUser;

    @Column(name = "porcentaje_aporte", nullable = false)
    protected Integer porcentajeAporte;

    public Integer getPorcentajeAporte() {
        return porcentajeAporte;
    }

    public void setPorcentajeAporte(Integer porcentajeAporte) {
        this.porcentajeAporte = porcentajeAporte;
    }

    public org.mg.mgweb.entity.TblUsers getIdUser() {
        return idUser;
    }

    public void setIdUser(org.mg.mgweb.entity.TblUsers idUser) {
        this.idUser = idUser;
    }

    public org.mg.mgweb.entity.TblGrupos getIdGrupo() {
        return idGrupo;
    }

    public void setIdGrupo(org.mg.mgweb.entity.TblGrupos idGrupo) {
        this.idGrupo = idGrupo;
    }

    public TblEventoTipos getIdEventoTipo() {
        return idEventoTipo;
    }

    public void setIdEventoTipo(TblEventoTipos idEventoTipo) {
        this.idEventoTipo = idEventoTipo;
    }

    public TblCentrosDeCosto getIdCentroDeCosto() {
        return idCentroDeCosto;
    }

    public void setIdCentroDeCosto(TblCentrosDeCosto idCentroDeCosto) {
        this.idCentroDeCosto = idCentroDeCosto;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}