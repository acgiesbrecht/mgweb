package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_cuentas_contables_por_defecto")
@Entity(name = "mgweb_TblCuentasContablesPorDefecto")
public class TblCuentasContablesPorDefecto extends BaseIntegerIdEntity {
    private static final long serialVersionUID = -1008690371896604546L;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_a_cobrar")
    protected TblCuentasContables idCuentaACobrar;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_aportes")
    protected TblCuentasContables idCuentaAportes;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_caja")
    protected TblCuentasContables idCuentaCaja;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_cta_cte")
    protected TblCuentasContables idCuentaCtaCte;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_debe_compras")
    protected TblCuentasContables idCuentaDebeCompras;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_donaciones")
    protected TblCuentasContables idCuentaDonaciones;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_haber_compras_factura_contado")
    protected TblCuentasContables idCuentaHaberComprasFacturaContado;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_cuenta_haber_compras_factura_credito")
    protected TblCuentasContables idCuentaHaberComprasFacturaCredito;

    public TblCuentasContables getIdCuentaHaberComprasFacturaCredito() {
        return idCuentaHaberComprasFacturaCredito;
    }

    public void setIdCuentaHaberComprasFacturaCredito(TblCuentasContables idCuentaHaberComprasFacturaCredito) {
        this.idCuentaHaberComprasFacturaCredito = idCuentaHaberComprasFacturaCredito;
    }

    public TblCuentasContables getIdCuentaHaberComprasFacturaContado() {
        return idCuentaHaberComprasFacturaContado;
    }

    public void setIdCuentaHaberComprasFacturaContado(TblCuentasContables idCuentaHaberComprasFacturaContado) {
        this.idCuentaHaberComprasFacturaContado = idCuentaHaberComprasFacturaContado;
    }

    public TblCuentasContables getIdCuentaDonaciones() {
        return idCuentaDonaciones;
    }

    public void setIdCuentaDonaciones(TblCuentasContables idCuentaDonaciones) {
        this.idCuentaDonaciones = idCuentaDonaciones;
    }

    public TblCuentasContables getIdCuentaDebeCompras() {
        return idCuentaDebeCompras;
    }

    public void setIdCuentaDebeCompras(TblCuentasContables idCuentaDebeCompras) {
        this.idCuentaDebeCompras = idCuentaDebeCompras;
    }

    public TblCuentasContables getIdCuentaCtaCte() {
        return idCuentaCtaCte;
    }

    public void setIdCuentaCtaCte(TblCuentasContables idCuentaCtaCte) {
        this.idCuentaCtaCte = idCuentaCtaCte;
    }

    public TblCuentasContables getIdCuentaCaja() {
        return idCuentaCaja;
    }

    public void setIdCuentaCaja(TblCuentasContables idCuentaCaja) {
        this.idCuentaCaja = idCuentaCaja;
    }

    public TblCuentasContables getIdCuentaAportes() {
        return idCuentaAportes;
    }

    public void setIdCuentaAportes(TblCuentasContables idCuentaAportes) {
        this.idCuentaAportes = idCuentaAportes;
    }

    public TblCuentasContables getIdCuentaACobrar() {
        return idCuentaACobrar;
    }

    public void setIdCuentaACobrar(TblCuentasContables idCuentaACobrar) {
        this.idCuentaACobrar = idCuentaACobrar;
    }
}