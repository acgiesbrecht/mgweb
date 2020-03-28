package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

@NamePattern("%s|id")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_miembros_relaciones")
@Entity(name = "mgweb_TblMiembrosRelaciones")
public class TblMiembrosRelaciones extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 4179229773891361515L;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_fin")
    protected LocalDateTime fechaFin;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_inicio")
    protected LocalDateTime fechaInicio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entidad_1")
    protected TblEntidades idEntidad1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entidad_2")
    protected TblEntidades idEntidad2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_miembros_familia")
    protected TblMiembrosFamilias idMiembrosFamilia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_miembros_relaciones_rol_1")
    protected TblMiembrosRelacionesRoles idMiembrosRelacionesRol1;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_miembros_relaciones_rol_2")
    protected TblMiembrosRelacionesRoles idMiembrosRelacionesRol2;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_miembros_relaciones_tipo")
    protected TblMiembrosRelacionesTipos idMiembrosRelacionesTipo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected org.mg.mgweb.entity.TblUsers idUser;

    public org.mg.mgweb.entity.TblUsers getIdUser() {
        return idUser;
    }

    public void setIdUser(org.mg.mgweb.entity.TblUsers idUser) {
        this.idUser = idUser;
    }

    public TblMiembrosRelacionesTipos getIdMiembrosRelacionesTipo() {
        return idMiembrosRelacionesTipo;
    }

    public void setIdMiembrosRelacionesTipo(TblMiembrosRelacionesTipos idMiembrosRelacionesTipo) {
        this.idMiembrosRelacionesTipo = idMiembrosRelacionesTipo;
    }

    public TblMiembrosRelacionesRoles getIdMiembrosRelacionesRol2() {
        return idMiembrosRelacionesRol2;
    }

    public void setIdMiembrosRelacionesRol2(TblMiembrosRelacionesRoles idMiembrosRelacionesRol2) {
        this.idMiembrosRelacionesRol2 = idMiembrosRelacionesRol2;
    }

    public TblMiembrosRelacionesRoles getIdMiembrosRelacionesRol1() {
        return idMiembrosRelacionesRol1;
    }

    public void setIdMiembrosRelacionesRol1(TblMiembrosRelacionesRoles idMiembrosRelacionesRol1) {
        this.idMiembrosRelacionesRol1 = idMiembrosRelacionesRol1;
    }

    public TblMiembrosFamilias getIdMiembrosFamilia() {
        return idMiembrosFamilia;
    }

    public void setIdMiembrosFamilia(TblMiembrosFamilias idMiembrosFamilia) {
        this.idMiembrosFamilia = idMiembrosFamilia;
    }

    public TblEntidades getIdEntidad2() {
        return idEntidad2;
    }

    public void setIdEntidad2(TblEntidades idEntidad2) {
        this.idEntidad2 = idEntidad2;
    }

    public TblEntidades getIdEntidad1() {
        return idEntidad1;
    }

    public void setIdEntidad1(TblEntidades idEntidad1) {
        this.idEntidad1 = idEntidad1;
    }

    public LocalDateTime getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(LocalDateTime fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public LocalDateTime getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(LocalDateTime fechaFin) {
        this.fechaFin = fechaFin;
    }
}