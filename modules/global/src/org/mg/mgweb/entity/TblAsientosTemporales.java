package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_asientos_temporales")
@Entity(name = "mgweb_TblAsientosTemporales")
public class TblAsientosTemporales extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -4470734410560029119L;
    @Column(name = "es_aporte")
    protected Boolean esAporte;
    @Column(name = "facturado")
    protected Boolean facturado;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechahora", nullable = false)
    protected Date fechahora;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_centro_de_costo_debe")
    protected TblCentrosDeCosto idCentroDeCostoDebe;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_centro_de_costo_haber")
    protected TblCentrosDeCosto idCentroDeCostoHaber;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_contable_debe")
    protected TblCuentasContables idCuentaContableDebe;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_contable_haber")
    protected TblCuentasContables idCuentaContableHaber;
    @Column(name = "monto", nullable = false)
    protected Integer monto;
    @JoinTable(name = "tbl_asientos_asientos_temporales",
            joinColumns = @JoinColumn(name = "id_asiento_temporal"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento"))
    @ManyToMany
    protected List<TblAsientos> tblAsientos;
    @JoinTable(name = "tbl_recibos_asientos_temporales",
            joinColumns = @JoinColumn(name = "id_asiento_temporal"),
            inverseJoinColumns = @JoinColumn(name = "id_recibo"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblRecibos> tblRecibos;
    @JoinTable(name = "tbl_transferencias_asientos_temporales",
            joinColumns = @JoinColumn(name = "id_asiento_temporal"),
            inverseJoinColumns = @JoinColumn(name = "id_transferencia"))
    @ManyToMany
    protected List<TblTransferencias> tblTransferencias;

    public List<TblTransferencias> getTblTransferencias() {
        return tblTransferencias;
    }

    public void setTblTransferencias(List<TblTransferencias> tblTransferencias) {
        this.tblTransferencias = tblTransferencias;
    }

    public List<org.mg.mgweb.entity.TblRecibos> getTblRecibos() {
        return tblRecibos;
    }

    public void setTblRecibos(List<org.mg.mgweb.entity.TblRecibos> tblRecibos) {
        this.tblRecibos = tblRecibos;
    }

    public List<TblAsientos> getTblAsientos() {
        return tblAsientos;
    }

    public void setTblAsientos(List<TblAsientos> tblAsientos) {
        this.tblAsientos = tblAsientos;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public TblCuentasContables getIdCuentaContableHaber() {
        return idCuentaContableHaber;
    }

    public void setIdCuentaContableHaber(TblCuentasContables idCuentaContableHaber) {
        this.idCuentaContableHaber = idCuentaContableHaber;
    }

    public TblCuentasContables getIdCuentaContableDebe() {
        return idCuentaContableDebe;
    }

    public void setIdCuentaContableDebe(TblCuentasContables idCuentaContableDebe) {
        this.idCuentaContableDebe = idCuentaContableDebe;
    }

    public TblCentrosDeCosto getIdCentroDeCostoHaber() {
        return idCentroDeCostoHaber;
    }

    public void setIdCentroDeCostoHaber(TblCentrosDeCosto idCentroDeCostoHaber) {
        this.idCentroDeCostoHaber = idCentroDeCostoHaber;
    }

    public TblCentrosDeCosto getIdCentroDeCostoDebe() {
        return idCentroDeCostoDebe;
    }

    public void setIdCentroDeCostoDebe(TblCentrosDeCosto idCentroDeCostoDebe) {
        this.idCentroDeCostoDebe = idCentroDeCostoDebe;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }

    public Boolean getFacturado() {
        return facturado;
    }

    public void setFacturado(Boolean facturado) {
        this.facturado = facturado;
    }

    public Boolean getEsAporte() {
        return esAporte;
    }

    public void setEsAporte(Boolean esAporte) {
        this.esAporte = esAporte;
    }
}