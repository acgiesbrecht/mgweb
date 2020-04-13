package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.entity.annotation.Lookup;
import com.haulmont.cuba.core.entity.annotation.LookupType;
import com.haulmont.cuba.core.entity.annotation.OnDeleteInverse;
import com.haulmont.cuba.core.global.DeletePolicy;
import com.haulmont.cuba.core.global.DesignSupport;
import com.haulmont.cuba.security.entity.User;
import org.mg.mgweb.converters.LocalDateAttributeConverter;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;
import org.springframework.cglib.core.Local;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@NamePattern("%s %s|fecha,descripcion")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_eventos")
@Entity(name = "mgweb_TblEventos")
public class TblEventos extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -104719805885893125L;

    @Column(name = "descripcion", length = 100)
    protected String descripcion;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateAttributeConverter.class)
    @Column(name = "fecha", nullable = false)
    protected LocalDate fecha;

    @NotNull
    @OnDeleteInverse(DeletePolicy.DENY)
    @Lookup(type = LookupType.DROPDOWN, actions = {"lookup"})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_centro_de_costo")
    protected TblCentrosDeCosto idCentroDeCosto;

    @OnDeleteInverse(DeletePolicy.DENY)
    @Lookup(type = LookupType.DROPDOWN, actions = {})
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento_tipo")
    protected TblEventoTipos idEventoTipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected User idUser;

    @Max(message = "Valor debe estar entre 0 y 100", value = 100)
    @Min(message = "Valor debe estar entre 0 y 100", value = 0)
    @NotNull(message = "No peude ser nulo")
    @Column(name = "porcentaje_aporte", nullable = false)
    protected Integer porcentajeAporte;

    @Transient
    @MetaProperty
    protected Integer porcentajeDonacion;

    public Integer getPorcentajeDonacion() {
        return 100 - porcentajeAporte;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public Integer getPorcentajeAporte() {
        return porcentajeAporte;
    }

    public void setPorcentajeAporte(Integer porcentajeAporte) {
        this.porcentajeAporte = porcentajeAporte;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
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

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}