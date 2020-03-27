package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.Date;

@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "nro"))
})
@Table(name = "tbl_timbrados")
@Entity(name = "mgweb_TblTimbrados")
public class TblTimbrados extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -2322998246877760826L;
    @Column(name = "activo")
    protected Boolean activo;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_inicio", nullable = false)
    protected Date fechaInicio;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_vencimiento", nullable = false)
    protected Date fechaVencimiento;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user")
    protected org.mg.mgweb.entity.TblUsers idUser;
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

    public org.mg.mgweb.entity.TblUsers getIdUser() {
        return idUser;
    }

    public void setIdUser(org.mg.mgweb.entity.TblUsers idUser) {
        this.idUser = idUser;
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

    public Boolean getActivo() {
        return activo;
    }

    public void setActivo(Boolean activo) {
        this.activo = activo;
    }
}