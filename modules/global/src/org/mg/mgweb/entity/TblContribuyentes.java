package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Table(name = "TBL_CONTRIBUYENTES")
@Entity(name = "mgweb_TblContribuyentes")
public class TblContribuyentes extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 4723941036352529725L;

    @NotNull
    @Column(name = "RUC_SIN_DV", nullable = false, length = 20)
    protected String rucSinDv;

    @NotNull
    @Column(name = "DV", nullable = false, length = 1)
    protected String dv;

    @NotNull
    @Column(name = "RAZON_SOCIAL", nullable = false)
    protected String razonSocial;

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getDv() {
        return dv;
    }

    public void setDv(String dv) {
        this.dv = dv;
    }

    public String getRucSinDv() {
        return rucSinDv;
    }

    public void setRucSinDv(String rucSinDv) {
        this.rucSinDv = rucSinDv;
    }
}