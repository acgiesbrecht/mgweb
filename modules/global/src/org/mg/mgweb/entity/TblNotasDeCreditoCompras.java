package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_notas_de_credito_compras")
@Entity(name = "mgweb_TblNotasDeCreditoCompras")
public class TblNotasDeCreditoCompras extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 4678713887120773687L;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechahora", nullable = false)
    protected Date fechahora;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user")
    protected org.mg.mgweb.entity.TblUsers idUser;
    @Column(name = "iva10", nullable = false)
    protected Integer iva10;
    @Column(name = "iva5", nullable = false)
    protected Integer iva5;
    @Column(name = "monto_exentas", nullable = false)
    protected Integer montoExentas;
    @Column(name = "monto_iva10", nullable = false)
    protected Integer montoIva10;
    @Column(name = "monto_iva5", nullable = false)
    protected Integer montoIva5;
    @Column(name = "nro", nullable = false, length = 15)
    protected String nro;
    @Column(name = "nro_timbrado", nullable = false, length = 8)
    protected String nroTimbrado;
    @Column(name = "observacion")
    protected String observacion;
    @Column(name = "razon_social", nullable = false)
    protected String razonSocial;
    @Column(name = "ruc", nullable = false, length = 20)
    protected String ruc;
    @JoinTable(name = "tbl_notas_de_credito_compras_asientos",
            joinColumns = @JoinColumn(name = "id_nota_de_credito"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblAsientos> tblAsientos;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "vencimiento_timbrado", nullable = false)
    protected Date vencimientoTimbrado;

    public Date getVencimientoTimbrado() {
        return vencimientoTimbrado;
    }

    public void setVencimientoTimbrado(Date vencimientoTimbrado) {
        this.vencimientoTimbrado = vencimientoTimbrado;
    }

    public List<org.mg.mgweb.entity.TblAsientos> getTblAsientos() {
        return tblAsientos;
    }

    public void setTblAsientos(List<org.mg.mgweb.entity.TblAsientos> tblAsientos) {
        this.tblAsientos = tblAsientos;
    }

    public String getRuc() {
        return ruc;
    }

    public void setRuc(String ruc) {
        this.ruc = ruc;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getNroTimbrado() {
        return nroTimbrado;
    }

    public void setNroTimbrado(String nroTimbrado) {
        this.nroTimbrado = nroTimbrado;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Integer getMontoIva5() {
        return montoIva5;
    }

    public void setMontoIva5(Integer montoIva5) {
        this.montoIva5 = montoIva5;
    }

    public Integer getMontoIva10() {
        return montoIva10;
    }

    public void setMontoIva10(Integer montoIva10) {
        this.montoIva10 = montoIva10;
    }

    public Integer getMontoExentas() {
        return montoExentas;
    }

    public void setMontoExentas(Integer montoExentas) {
        this.montoExentas = montoExentas;
    }

    public Integer getIva5() {
        return iva5;
    }

    public void setIva5(Integer iva5) {
        this.iva5 = iva5;
    }

    public Integer getIva10() {
        return iva10;
    }

    public void setIva10(Integer iva10) {
        this.iva10 = iva10;
    }

    public org.mg.mgweb.entity.TblUsers getIdUser() {
        return idUser;
    }

    public void setIdUser(org.mg.mgweb.entity.TblUsers idUser) {
        this.idUser = idUser;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }
}