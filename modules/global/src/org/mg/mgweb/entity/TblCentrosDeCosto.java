package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_centros_de_costo")
@Entity(name = "mgweb_TblCentrosDeCosto")
public class TblCentrosDeCosto extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 6484783048609023578L;
    @Column(name = "cta_cte", nullable = false)
    protected Integer ctaCte;
    @Column(name = "descripcion", nullable = false)
    protected String descripcion;
    @Column(name = "es_donacion_externa")
    protected Boolean esDonacionExterna;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_contable_cta_cte_por_defecto")
    protected org.mg.mgweb.entity.TblCuentasContables idCuentaContableCtaCtePorDefecto;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_contable_efectivo_por_defecto")
    protected org.mg.mgweb.entity.TblCuentasContables idCuentaContableEfectivoPorDefecto;
    @Column(name = "preferido")
    protected Boolean preferido;

    public Boolean getPreferido() {
        return preferido;
    }

    public void setPreferido(Boolean preferido) {
        this.preferido = preferido;
    }

    public org.mg.mgweb.entity.TblCuentasContables getIdCuentaContableEfectivoPorDefecto() {
        return idCuentaContableEfectivoPorDefecto;
    }

    public void setIdCuentaContableEfectivoPorDefecto(org.mg.mgweb.entity.TblCuentasContables idCuentaContableEfectivoPorDefecto) {
        this.idCuentaContableEfectivoPorDefecto = idCuentaContableEfectivoPorDefecto;
    }

    public org.mg.mgweb.entity.TblCuentasContables getIdCuentaContableCtaCtePorDefecto() {
        return idCuentaContableCtaCtePorDefecto;
    }

    public void setIdCuentaContableCtaCtePorDefecto(org.mg.mgweb.entity.TblCuentasContables idCuentaContableCtaCtePorDefecto) {
        this.idCuentaContableCtaCtePorDefecto = idCuentaContableCtaCtePorDefecto;
    }

    public Boolean getEsDonacionExterna() {
        return esDonacionExterna;
    }

    public void setEsDonacionExterna(Boolean esDonacionExterna) {
        this.esDonacionExterna = esDonacionExterna;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Integer getCtaCte() {
        return ctaCte;
    }

    public void setCtaCte(Integer ctaCte) {
        this.ctaCte = ctaCte;
    }
}