package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;
import java.util.List;

@NamePattern("%s %s|id,fechahora")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_transferencias")
@Entity(name = "mgweb_TblTransferencias")
public class TblTransferencias extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -8469543354781673675L;

    @Column(name = "cobrado")
    protected Boolean cobrado;

    @Column(name = "concepto", length = 50)
    protected String concepto;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechahora", nullable = false)
    protected LocalDateTime fechahora;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechahora_compromiso")
    protected LocalDateTime fechahoraCompromiso;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entidad")
    protected TblEntidades idEntidad;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento")
    protected org.mg.mgweb.entity.TblEventos idEvento;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_evento_detalle")
    protected org.mg.mgweb.entity.TblEventoDetalle idEventoDetalle;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento_tipo")
    protected org.mg.mgweb.entity.TblEventoTipos idEventoTipo;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user")
    protected org.mg.mgweb.entity.TblUsers idUser;

    @Column(name = "monto_aporte", nullable = false)
    protected Integer montoAporte;

    @Column(name = "monto_donacion", nullable = false)
    protected Integer montoDonacion;

    @Column(name = "seq_pago", nullable = false)
    protected Integer seqPago;

    @JoinTable(name = "tbl_transferencias_asientos_temporales",
            joinColumns = @JoinColumn(name = "id_transferencia"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento_temporal"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblAsientosTemporales> tblAsientosTemporales;

    public List<org.mg.mgweb.entity.TblAsientosTemporales> getTblAsientosTemporales() {
        return tblAsientosTemporales;
    }

    public void setTblAsientosTemporales(List<org.mg.mgweb.entity.TblAsientosTemporales> tblAsientosTemporales) {
        this.tblAsientosTemporales = tblAsientosTemporales;
    }

    public Integer getSeqPago() {
        return seqPago;
    }

    public void setSeqPago(Integer seqPago) {
        this.seqPago = seqPago;
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

    public org.mg.mgweb.entity.TblUsers getIdUser() {
        return idUser;
    }

    public void setIdUser(org.mg.mgweb.entity.TblUsers idUser) {
        this.idUser = idUser;
    }

    public org.mg.mgweb.entity.TblEventoTipos getIdEventoTipo() {
        return idEventoTipo;
    }

    public void setIdEventoTipo(org.mg.mgweb.entity.TblEventoTipos idEventoTipo) {
        this.idEventoTipo = idEventoTipo;
    }

    public org.mg.mgweb.entity.TblEventoDetalle getIdEventoDetalle() {
        return idEventoDetalle;
    }

    public void setIdEventoDetalle(org.mg.mgweb.entity.TblEventoDetalle idEventoDetalle) {
        this.idEventoDetalle = idEventoDetalle;
    }

    public org.mg.mgweb.entity.TblEventos getIdEvento() {
        return idEvento;
    }

    public void setIdEvento(org.mg.mgweb.entity.TblEventos idEvento) {
        this.idEvento = idEvento;
    }

    public TblEntidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(TblEntidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    public LocalDateTime getFechahoraCompromiso() {
        return fechahoraCompromiso;
    }

    public void setFechahoraCompromiso(LocalDateTime fechahoraCompromiso) {
        this.fechahoraCompromiso = fechahoraCompromiso;
    }

    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public Boolean getCobrado() {
        return cobrado;
    }

    public void setCobrado(Boolean cobrado) {
        this.cobrado = cobrado;
    }
}