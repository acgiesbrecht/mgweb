package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

@NamePattern("%s|nro")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_timbrados_notas_de_credito")
@Entity(name = "mgweb_TblTimbradosNotasDeCredito")
public class TblTimbradosNotasDeCredito extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 1406707424242041338L;

    @Column(name = "activo")
    protected Boolean activo;

    @Column(name = "establecimiento", nullable = false, length = 3)
    protected String establecimiento;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_inicio", nullable = false)
    protected LocalDateTime fechaInicio;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_vencimiento", nullable = false)
    protected LocalDateTime fechaVencimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected com.haulmont.cuba.security.entity.User idUser;

    @Column(name = "nro", nullable = false, length = 8)
    protected String nro;

    @Column(name = "nro_nota_de_credito_fin", nullable = false)
    protected Integer nroNotaDeCreditoFin;

    @Column(name = "nro_nota_de_credito_incio", nullable = false)
    protected Integer nroNotaDeCreditoIncio;

    @Column(name = "punto_de_expedicion", nullable = false, length = 3)
    protected String puntoDeExpedicion;

    public String getPuntoDeExpedicion() {
        return puntoDeExpedicion;
    }

    public void setPuntoDeExpedicion(String puntoDeExpedicion) {
        this.puntoDeExpedicion = puntoDeExpedicion;
    }

    public Integer getNroNotaDeCreditoIncio() {
        return nroNotaDeCreditoIncio;
    }

    public void setNroNotaDeCreditoIncio(Integer nroNotaDeCreditoIncio) {
        this.nroNotaDeCreditoIncio = nroNotaDeCreditoIncio;
    }

    public Integer getNroNotaDeCreditoFin() {
        return nroNotaDeCreditoFin;
    }

    public void setNroNotaDeCreditoFin(Integer nroNotaDeCreditoFin) {
        this.nroNotaDeCreditoFin = nroNotaDeCreditoFin;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public com.haulmont.cuba.security.entity.User getIdUser() {
        return idUser;
    }

    public void setIdUser(com.haulmont.cuba.security.entity.User idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public String getEstablecimiento() {
        return establecimiento;
    }

    public void setEstablecimiento(String establecimiento) {
        this.establecimiento = establecimiento;
    }

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}