package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|descripcion")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_evento_tipos")
@Entity(name = "mgweb_TblEventoTipos")
public class TblEventoTipos extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -9047680757171802510L;

    @Column(name = "descripcion", nullable = false, length = 50)
    protected String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}