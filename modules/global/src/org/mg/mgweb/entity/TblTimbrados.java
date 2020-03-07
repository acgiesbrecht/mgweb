package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.UUID;

@Table(name = "TBL_TIMBRADOS")
@Entity(name = "mgweb_TblTimbrados")
public class TblTimbrados extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -938952079700774210L;

    @NotNull
    @Column(name = "NRO", nullable = false)
    protected Integer nro;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_INICIO", nullable = false)
    protected Date fechaInicio;

    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "FECHA_VENCIMIENTO", nullable = false)
    protected Date fechaVencimiento;

    @NotNull
    @Column(name = "NRO_FACTURA_INICIO", nullable = false)
    protected Integer nroFacturaInicio;

    @NotNull
    @Column(name = "NRO_FACTURA_FIN", nullable = false)
    protected Integer nroFacturaFin;

    @Temporal(TemporalType.DATE)
    @Column(name = "ACTIVO")
    protected Date activo;

    @Column(name = "ID_USER")
    protected UUID idUser;

    public UUID getIdUser() {
        return idUser;
    }

    public void setIdUser(UUID idUser) {
        this.idUser = idUser;
    }

    public Date getActivo() {
        return activo;
    }

    public void setActivo(Date activo) {
        this.activo = activo;
    }

    public Integer getNroFacturaFin() {
        return nroFacturaFin;
    }

    public void setNroFacturaFin(Integer nroFacturaFin) {
        this.nroFacturaFin = nroFacturaFin;
    }

    public Integer getNroFacturaInicio() {
        return nroFacturaInicio;
    }

    public void setNroFacturaInicio(Integer nroFacturaInicio) {
        this.nroFacturaInicio = nroFacturaInicio;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Integer getNro() {
        return nro;
    }

    public void setNro(Integer nro) {
        this.nro = nro;
    }
}