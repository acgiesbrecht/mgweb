package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;

@NamePattern("%s|descripcion")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_cuentas_contables")
@Entity(name = "mgweb_TblCuentasContables")
public class TblCuentasContables extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -8072661469852138411L;

    @Column(name = "descripcion", nullable = false)
    protected String descripcion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_cuenta_madre")
    protected TblCuentasContables idCuentaMadre;

    @Column(name = "imputable")
    protected Boolean imputable;

    public Boolean getImputable() {
        return imputable;
    }

    public void setImputable(Boolean imputable) {
        this.imputable = imputable;
    }

    public TblCuentasContables getIdCuentaMadre() {
        return idCuentaMadre;
    }

    public void setIdCuentaMadre(TblCuentasContables idCuentaMadre) {
        this.idCuentaMadre = idCuentaMadre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}