package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;
import java.util.List;

@NamePattern("%s %s|id,fechahora")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_asientos")
@Entity(name = "mgweb_TblAsientos")
public class TblAsientos extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -2558281534293276927L;

    @Column(name = "asiento_manual")
    protected Boolean asientoManual;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechahora", nullable = false)
    protected LocalDateTime fechahora;

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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected com.haulmont.cuba.security.entity.User idUser;

    @Column(name = "monto", nullable = false)
    protected Integer monto;

    @Column(name = "observacion")
    protected String observacion;

    @JoinTable(name = "tbl_asientos_asientos_temporales",
            joinColumns = @JoinColumn(name = "id_asiento"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento_temporal"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblAsientosTemporales> tblAsientosTemporales;

    @JoinTable(name = "tbl_autofacturas_asientos",
            joinColumns = @JoinColumn(name = "id_asiento"),
            inverseJoinColumns = @JoinColumn(name = "id_autofactura"))
    @ManyToMany
    protected List<TblAutofacturas> tblAutofacturas;

    @JoinTable(name = "tbl_evento_detalle_asientos",
            joinColumns = @JoinColumn(name = "id_asiento"),
            inverseJoinColumns = @JoinColumn(name = "id_evento_detalle"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblEventoDetalle> tblEventoDetalle;

    @JoinTable(name = "tbl_facturas_asientos",
            joinColumns = @JoinColumn(name = "id_asiento"),
            inverseJoinColumns = @JoinColumn(name = "nro_factura"))
    @ManyToMany
    protected List<TblFacturas> tblFacturas;

    @JoinTable(name = "tbl_facturas_compra_asientos",
            joinColumns = @JoinColumn(name = "id_asiento"),
            inverseJoinColumns = @JoinColumn(name = "id_factura_compra"))
    @ManyToMany
    protected List<TblFacturasCompra> tblFacturasCompra;

    @JoinTable(name = "tbl_notas_de_credito_asientos",
            joinColumns = @JoinColumn(name = "id_asiento"),
            inverseJoinColumns = @JoinColumn(name = "id_nota_de_credito"))
    @ManyToMany
    protected List<TblNotasDeCredito> tblNotasDeCredito;

    @JoinTable(name = "tbl_notas_de_credito_compras_asientos",
            joinColumns = @JoinColumn(name = "id_asiento"),
            inverseJoinColumns = @JoinColumn(name = "id_nota_de_credito"))
    @ManyToMany
    protected List<TblNotasDeCreditoCompras> tblNotasDeCreditoCompras;

    @JoinTable(name = "tbl_recibos_compra_asientos",
            joinColumns = @JoinColumn(name = "id_asiento"),
            inverseJoinColumns = @JoinColumn(name = "id_recibo"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblRecibosCompra> tblRecibosCompra;

    public List<org.mg.mgweb.entity.TblRecibosCompra> getTblRecibosCompra() {
        return tblRecibosCompra;
    }

    public void setTblRecibosCompra(List<org.mg.mgweb.entity.TblRecibosCompra> tblRecibosCompra) {
        this.tblRecibosCompra = tblRecibosCompra;
    }

    public List<TblNotasDeCreditoCompras> getTblNotasDeCreditoCompras() {
        return tblNotasDeCreditoCompras;
    }

    public void setTblNotasDeCreditoCompras(List<TblNotasDeCreditoCompras> tblNotasDeCreditoCompras) {
        this.tblNotasDeCreditoCompras = tblNotasDeCreditoCompras;
    }

    public List<TblNotasDeCredito> getTblNotasDeCredito() {
        return tblNotasDeCredito;
    }

    public void setTblNotasDeCredito(List<TblNotasDeCredito> tblNotasDeCredito) {
        this.tblNotasDeCredito = tblNotasDeCredito;
    }

    public List<TblFacturasCompra> getTblFacturasCompra() {
        return tblFacturasCompra;
    }

    public void setTblFacturasCompra(List<TblFacturasCompra> tblFacturasCompra) {
        this.tblFacturasCompra = tblFacturasCompra;
    }

    public List<TblFacturas> getTblFacturas() {
        return tblFacturas;
    }

    public void setTblFacturas(List<TblFacturas> tblFacturas) {
        this.tblFacturas = tblFacturas;
    }

    public List<org.mg.mgweb.entity.TblEventoDetalle> getTblEventoDetalle() {
        return tblEventoDetalle;
    }

    public void setTblEventoDetalle(List<org.mg.mgweb.entity.TblEventoDetalle> tblEventoDetalle) {
        this.tblEventoDetalle = tblEventoDetalle;
    }

    public List<TblAutofacturas> getTblAutofacturas() {
        return tblAutofacturas;
    }

    public void setTblAutofacturas(List<TblAutofacturas> tblAutofacturas) {
        this.tblAutofacturas = tblAutofacturas;
    }

    public List<org.mg.mgweb.entity.TblAsientosTemporales> getTblAsientosTemporales() {
        return tblAsientosTemporales;
    }

    public void setTblAsientosTemporales(List<org.mg.mgweb.entity.TblAsientosTemporales> tblAsientosTemporales) {
        this.tblAsientosTemporales = tblAsientosTemporales;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public com.haulmont.cuba.security.entity.User getIdUser() {
        return idUser;
    }

    public void setIdUser(com.haulmont.cuba.security.entity.User idUser) {
        this.idUser = idUser;
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

    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }

    public Boolean getAsientoManual() {
        return asientoManual;
    }

    public void setAsientoManual(Boolean asientoManual) {
        this.asientoManual = asientoManual;
    }
}