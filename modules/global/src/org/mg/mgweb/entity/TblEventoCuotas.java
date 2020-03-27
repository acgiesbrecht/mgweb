package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.Date;

@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_evento"))
})
@Table(name = "tbl_evento_cuotas")
@Entity(name = "mgweb_TblEventoCuotas")
public class TblEventoCuotas extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 1178810832418662947L;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_1")
    protected Date fecha1;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_2")
    protected Date fecha2;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_3")
    protected Date fecha3;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_4")
    protected Date fecha4;
    @Column(name = "id_user")
    protected Integer idUser;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public Date getFecha4() {
        return fecha4;
    }

    public void setFecha4(Date fecha4) {
        this.fecha4 = fecha4;
    }

    public Date getFecha3() {
        return fecha3;
    }

    public void setFecha3(Date fecha3) {
        this.fecha3 = fecha3;
    }

    public Date getFecha2() {
        return fecha2;
    }

    public void setFecha2(Date fecha2) {
        this.fecha2 = fecha2;
    }

    public Date getFecha1() {
        return fecha1;
    }

    public void setFecha1(Date fecha1) {
        this.fecha1 = fecha1;
    }
}