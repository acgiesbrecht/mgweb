package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|nombre")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_iglesia")
@Entity(name = "mgweb_TblIglesia")
public class TblIglesia extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -4253800478027415058L;

    @Column(name = "box")
    protected Integer box;

    @MetaProperty(datatype = "ccm")
    @Column(name = "ctacte")
    protected Integer ctacte;

    @Column(name = "domicilio", length = 50)
    protected String domicilio;

    @Column(name = "nombre", nullable = false, length = 256)
    protected String nombre;

    @Column(name = "ruc_sin_dv", length = 20)
    protected String rucSinDv;

    public String getRucSinDv() {
        return rucSinDv;
    }

    public void setRucSinDv(String rucSinDv) {
        this.rucSinDv = rucSinDv;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getCtacte() {
        return ctacte;
    }

    public void setCtacte(Integer ctacte) {
        this.ctacte = ctacte;
    }

    public Integer getBox() {
        return box;
    }

    public void setBox(Integer box) {
        this.box = box;
    }
}