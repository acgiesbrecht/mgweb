package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|descripcion")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_miembros_familias")
@Entity(name = "mgweb_TblMiembrosFamilias")
public class TblMiembrosFamilias extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 5069033553969781309L;

    @Column(name = "descripcion", length = 50)
    protected String descripcion;

    @Column(name = "foto")
    protected byte[] foto;

    public byte[] getFoto() {
        return foto;
    }

    public void setFoto(byte[] foto) {
        this.foto = foto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}