package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_miembros_categorias_de_pago")
@Entity(name = "mgweb_TblMiembrosCategoriasDePago")
public class TblMiembrosCategoriasDePago extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 165770548770993744L;
    @Column(name = "descripcion", nullable = false, length = 50)
    protected String descripcion;
    @Column(name = "es_activacion")
    protected Boolean esActivacion;

    public Boolean getEsActivacion() {
        return esActivacion;
    }

    public void setEsActivacion(Boolean esActivacion) {
        this.esActivacion = esActivacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}