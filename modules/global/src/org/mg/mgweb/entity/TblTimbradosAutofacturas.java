package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

@NamePattern("%s|nro")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_timbrados_autofacturas")
@Entity(name = "mgweb_TblTimbradosAutofacturas")
public class TblTimbradosAutofacturas extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -2094645105057262586L;

    @Column(name = "activo")
    protected Boolean activo;

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

    @Column(name = "nro_factura_fin", nullable = false)
    protected Integer nroFacturaFin;

    @Column(name = "nro_factura_incio", nullable = false)
    protected Integer nroFacturaIncio;

    public Integer getNroFacturaIncio() {
        return nroFacturaIncio;
    }

    public void setNroFacturaIncio(Integer nroFacturaIncio) {
        this.nroFacturaIncio = nroFacturaIncio;
    }

    public Integer getNroFacturaFin() {
        return nroFacturaFin;
    }

    public void setNroFacturaFin(Integer nroFacturaFin) {
        this.nroFacturaFin = nroFacturaFin;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}