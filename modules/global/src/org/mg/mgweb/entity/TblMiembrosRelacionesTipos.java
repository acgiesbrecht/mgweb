package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@NamePattern("%s|descripcion")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_miembros_relaciones_tipos")
@Entity(name = "mgweb_TblMiembrosRelacionesTipos")
public class TblMiembrosRelacionesTipos extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 4288418712648674246L;

    @Column(name = "descripcion", nullable = false, length = 50)
    protected String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}