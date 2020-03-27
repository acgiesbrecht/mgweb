package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_contribuyentes")
@Entity(name = "mgweb_TblContribuyentes")
public class TblContribuyentes extends BaseStringIdEntity {
    private static final long serialVersionUID = 669448772245106779L;
    @Id
    @Column(name = "ruc_sin_dv", nullable = false, length = 20)
    protected String rucSinDv;
    @Column(name = "dv", nullable = false, length = 1)
    protected String dv;
    @Column(name = "razon_social", nullable = false, length = 256)
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

    @Override
    public void setId(String id) {
        this.rucSinDv = id;
    }

    @Override
    public String getId() {
        return rucSinDv;
    }

    public String getRucSinDv() {
        return rucSinDv;
    }

    public void setRucSinDv(String rucSinDv) {
        this.rucSinDv = rucSinDv;
    }
}