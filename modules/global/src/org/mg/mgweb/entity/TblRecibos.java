package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_recibos")
@Entity(name = "mgweb_TblRecibos")
public class TblRecibos extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 2746979347628181383L;
    @Column(name = "concepto", length = 50)
    protected String concepto;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechahora", nullable = false)
    protected Date fechahora;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechahora_compromiso")
    protected Date fechahoraCompromiso;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entidad")
    protected TblEntidades idEntidad;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    protected TblEventos idEvento;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento_tipo")
    protected TblEventoTipos idEventoTipo;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user")
    protected TblUsers idUser;
    @Column(name = "monto_aporte", nullable = false)
    protected Integer montoAporte;
    @Column(name = "monto_donacion", nullable = false)
    protected Integer montoDonacion;
    @JoinTable(name = "tbl_recibos_asientos_temporales",
            joinColumns = @JoinColumn(name = "id_recibo"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento_temporal"))
    @ManyToMany
    protected List<TblAsientosTemporales> tblAsientosTemporales;

    public List<TblAsientosTemporales> getTblAsientosTemporales() {
        return tblAsientosTemporales;
    }

    public void setTblAsientosTemporales(List<TblAsientosTemporales> tblAsientosTemporales) {
        this.tblAsientosTemporales = tblAsientosTemporales;
    }

    public Integer getMontoDonacion() {
        return montoDonacion;
    }

    public void setMontoDonacion(Integer montoDonacion) {
        this.montoDonacion = montoDonacion;
    }

    public Integer getMontoAporte() {
        return montoAporte;
    }

    public void setMontoAporte(Integer montoAporte) {
        this.montoAporte = montoAporte;
    }

    public TblUsers getIdUser() {
        return idUser;
    }

    public void setIdUser(TblUsers idUser) {
        this.idUser = idUser;
    }

    public TblEventoTipos getIdEventoTipo() {
        return idEventoTipo;
    }

    public void setIdEventoTipo(TblEventoTipos idEventoTipo) {
        this.idEventoTipo = idEventoTipo;
    }

    public TblEventos getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(TblEventos idEvento) {
        this.idEvento = idEvento;
    }

    public TblEntidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(TblEntidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Date getFechahoraCompromiso() {
        return fechahoraCompromiso;
    }

    public void setFechahoraCompromiso(Date fechahoraCompromiso) {
        this.fechahoraCompromiso = fechahoraCompromiso;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}