package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "TBL_MIEMBROS_CATEGORIAS_DE_PAGO")
@Entity(name = "mgweb_TblMiembrosCategoriasDePago")
public class TblMiembrosCategoriasDePago extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 6534755541226260550L;

    @NotNull
    @Column(name = "DESCRIPCION", nullable = false, length = 50)
    protected String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}