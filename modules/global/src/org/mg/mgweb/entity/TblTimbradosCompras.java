package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseStringIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;

import com.haulmont.cuba.security.entity.User;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

@NamePattern("%s|nro")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_timbrados_compras")
@Entity(name = "mgweb_TblTimbradosCompras")
public class TblTimbradosCompras extends BaseStringIdEntity {
    private static final long serialVersionUID = -5259187649668382045L;

    @Id
    @Column(name = "nro", nullable = false, length = 8)
    protected String nro;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_vencimiento", nullable = false)
    protected LocalDateTime fechaVencimiento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected User idUser;

    @Column(name = "ruc_sin_dv", nullable = false, length = 20)
    protected String rucSinDv;

    public String getRucSinDv() {
        return rucSinDv;
    }

    public void setRucSinDv(String rucSinDv) {
        this.rucSinDv = rucSinDv;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(LocalDateTime fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    @Override
    public void setId(String id) {
        this.nro = id;
    }

    @Override
    public String getId() {
        return nro;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }
}