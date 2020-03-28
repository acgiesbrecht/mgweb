package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

@NamePattern("%s %s|id,fecha1")
@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "id_evento"))
})
@Table(name = "tbl_evento_cuotas")
@Entity(name = "mgweb_TblEventoCuotas")
public class TblEventoCuotas extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 1178810832418662947L;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_1")
    protected LocalDateTime fecha1;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_2")
    protected LocalDateTime fecha2;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_3")
    protected LocalDateTime fecha3;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_4")
    protected LocalDateTime fecha4;

    @Column(name = "id_user")
    protected Integer idUser;

    public Integer getIdUser() {
        return idUser;
    }

    public void setIdUser(Integer idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getFecha4() {
        return fecha4;
    }

    public void setFecha4(LocalDateTime fecha4) {
        this.fecha4 = fecha4;
    }

    public LocalDateTime getFecha3() {
        return fecha3;
    }

    public void setFecha3(LocalDateTime fecha3) {
        this.fecha3 = fecha3;
    }

    public LocalDateTime getFecha2() {
        return fecha2;
    }

    public void setFecha2(LocalDateTime fecha2) {
        this.fecha2 = fecha2;
    }

    public LocalDateTime getFecha1() {
        return fecha1;
    }

    public void setFecha1(LocalDateTime fecha1) {
        this.fecha1 = fecha1;
    }
}