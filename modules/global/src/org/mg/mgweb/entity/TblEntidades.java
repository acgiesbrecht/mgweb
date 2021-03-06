package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.MetaProperty;
import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@NamePattern("%s, %s / %s / %s|apellidos,nombres,ctacte,rucSinDv")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_entidades")
@Entity(name = "mgweb_TblEntidades")
public class TblEntidades extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -5492348477571791017L;

    @Column(name = "apellidos", nullable = false, length = 128)
    protected String apellidos;

    @Column(name = "aporte_mensual", nullable = false)
    protected Long aporteMensual;

    @Column(name = "aporte_saldo_anterior")
    protected Long aporteSaldoAnterior;

    @Column(name = "box")
    protected Integer box;

    @Column(name = "cantidad_de_dependientes_aportantes", nullable = false)
    protected Integer cantidadDeDependientesAportantes;

    @MetaProperty(datatype = "ccm", mandatory = true)
    @Column(name = "ctacte", nullable = false)
    protected Integer ctacte;

    @Column(name = "domicilio", length = 50)
    protected String domicilio;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_bautismo")
    protected LocalDateTime fechaBautismo;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_defuncion")
    protected LocalDateTime fechaDefuncion;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_entrada_congregacion")
    protected LocalDateTime fechaEntradaCongregacion;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_nacimiento")
    protected LocalDateTime fechaNacimiento;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fecha_salida_congregacion")
    protected LocalDateTime fechaSalidaCongregacion;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_area_servicio_en_iglesia")
    protected org.mg.mgweb.entity.TblAreasServicioEnIglesia idAreaServicioEnIglesia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_entidad_pagante_aportes")
    protected TblEntidades idEntidadPaganteAportes;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_forma_de_pago_preferida")
    protected org.mg.mgweb.entity.TblFormasDePago idFormaDePagoPreferida;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_miembros_alergia")
    protected org.mg.mgweb.entity.TblMiembrosAlergias idMiembrosAlergia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_miembros_categoria_de_pago")
    protected org.mg.mgweb.entity.TblMiembrosCategoriasDePago idMiembrosCategoriaDePago;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected com.haulmont.cuba.security.entity.User idUser;

    @Column(name = "is_miembro_activo")
    protected Boolean isMiembroActivo;

    @Column(name = "mes_fin_aporte")
    protected Integer mesFinAporte;

    @Column(name = "mes_inicio_aporte")
    protected Integer mesInicioAporte;

    @Column(name = "nombres", nullable = false, length = 128)
    protected String nombres;

    @Column(name = "razon_social", nullable = false, length = 256)
    protected String razonSocial;

    @Column(name = "ruc_sin_dv", nullable = false, length = 20)
    protected String rucSinDv;

    public void setFechaBautismo(LocalDateTime fechaBautismo) {
        this.fechaBautismo = fechaBautismo;
    }

    public LocalDateTime getFechaBautismo() {
        return fechaBautismo;
    }

    public void setFechaDefuncion(LocalDateTime fechaDefuncion) {
        this.fechaDefuncion = fechaDefuncion;
    }

    public LocalDateTime getFechaDefuncion() {
        return fechaDefuncion;
    }

    public void setFechaEntradaCongregacion(LocalDateTime fechaEntradaCongregacion) {
        this.fechaEntradaCongregacion = fechaEntradaCongregacion;
    }

    public LocalDateTime getFechaEntradaCongregacion() {
        return fechaEntradaCongregacion;
    }

    public void setFechaNacimiento(LocalDateTime fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDateTime getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaSalidaCongregacion(LocalDateTime fechaSalidaCongregacion) {
        this.fechaSalidaCongregacion = fechaSalidaCongregacion;
    }

    public LocalDateTime getFechaSalidaCongregacion() {
        return fechaSalidaCongregacion;
    }

    public String getRucSinDv() {
        return rucSinDv;
    }

    public void setRucSinDv(String rucSinDv) {
        this.rucSinDv = rucSinDv;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public Integer getMesInicioAporte() {
        return mesInicioAporte;
    }

    public void setMesInicioAporte(Integer mesInicioAporte) {
        this.mesInicioAporte = mesInicioAporte;
    }

    public Integer getMesFinAporte() {
        return mesFinAporte;
    }

    public void setMesFinAporte(Integer mesFinAporte) {
        this.mesFinAporte = mesFinAporte;
    }

    public Boolean getIsMiembroActivo() {
        return isMiembroActivo;
    }

    public void setIsMiembroActivo(Boolean isMiembroActivo) {
        this.isMiembroActivo = isMiembroActivo;
    }

    public com.haulmont.cuba.security.entity.User getIdUser() {
        return idUser;
    }

    public void setIdUser(com.haulmont.cuba.security.entity.User idUser) {
        this.idUser = idUser;
    }

    public org.mg.mgweb.entity.TblMiembrosCategoriasDePago getIdMiembrosCategoriaDePago() {
        return idMiembrosCategoriaDePago;
    }

    public void setIdMiembrosCategoriaDePago(org.mg.mgweb.entity.TblMiembrosCategoriasDePago idMiembrosCategoriaDePago) {
        this.idMiembrosCategoriaDePago = idMiembrosCategoriaDePago;
    }

    public org.mg.mgweb.entity.TblMiembrosAlergias getIdMiembrosAlergia() {
        return idMiembrosAlergia;
    }

    public void setIdMiembrosAlergia(org.mg.mgweb.entity.TblMiembrosAlergias idMiembrosAlergia) {
        this.idMiembrosAlergia = idMiembrosAlergia;
    }

    public org.mg.mgweb.entity.TblFormasDePago getIdFormaDePagoPreferida() {
        return idFormaDePagoPreferida;
    }

    public void setIdFormaDePagoPreferida(org.mg.mgweb.entity.TblFormasDePago idFormaDePagoPreferida) {
        this.idFormaDePagoPreferida = idFormaDePagoPreferida;
    }

    public TblEntidades getIdEntidadPaganteAportes() {
        return idEntidadPaganteAportes;
    }

    public void setIdEntidadPaganteAportes(TblEntidades idEntidadPaganteAportes) {
        this.idEntidadPaganteAportes = idEntidadPaganteAportes;
    }

    public org.mg.mgweb.entity.TblAreasServicioEnIglesia getIdAreaServicioEnIglesia() {
        return idAreaServicioEnIglesia;
    }

    public void setIdAreaServicioEnIglesia(org.mg.mgweb.entity.TblAreasServicioEnIglesia idAreaServicioEnIglesia) {
        this.idAreaServicioEnIglesia = idAreaServicioEnIglesia;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Integer getCtacte() {
        return ctacte;
    }

    public void setCtacte(Integer ctacte) {
        this.ctacte = ctacte;
    }

    public Integer getCantidadDeDependientesAportantes() {
        return cantidadDeDependientesAportantes;
    }

    public void setCantidadDeDependientesAportantes(Integer cantidadDeDependientesAportantes) {
        this.cantidadDeDependientesAportantes = cantidadDeDependientesAportantes;
    }

    public Integer getBox() {
        return box;
    }

    public void setBox(Integer box) {
        this.box = box;
    }

    public Long getAporteSaldoAnterior() {
        return aporteSaldoAnterior;
    }

    public void setAporteSaldoAnterior(Long aporteSaldoAnterior) {
        this.aporteSaldoAnterior = aporteSaldoAnterior;
    }

    public Long getAporteMensual() {
        return aporteMensual;
    }

    public void setAporteMensual(Long montoMensual) {
        this.aporteMensual = aporteMensual;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }
}