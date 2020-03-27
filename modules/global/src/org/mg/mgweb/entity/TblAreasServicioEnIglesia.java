package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_areas_servicio_en_iglesia")
@Entity(name = "mgweb_TblAreasServicioEnIglesia")
public class TblAreasServicioEnIglesia extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -7131788410287422235L;
    @Column(name = "descripcion", nullable = false, length = 50)
    protected String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}