package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|descripcion")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_categorias_articulos")
@Entity(name = "mgweb_TblCategoriasArticulos")
public class TblCategoriasArticulos extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -1161599215891632214L;

    @Column(name = "descripcion", length = 50)
    protected String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}