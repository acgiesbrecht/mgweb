package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;
import java.util.List;

@NamePattern("%s %s|nro,nroTimbrado")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_notas_de_credito_compras")
@Entity(name = "mgweb_TblNotasDeCreditoCompras")
public class TblNotasDeCreditoCompras extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 4678713887120773687L;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechahora", nullable = false)
    protected LocalDateTime fechahora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected com.haulmont.cuba.security.entity.User idUser;

    @Column(name = "iva10", nullable = false)
    protected Long iva10;

    @Column(name = "iva5", nullable = false)
    protected Long iva5;

    @Column(name = "monto_exentas", nullable = false)
    protected Long montoExentas;

    @Column(name = "monto_iva10", nullable = false)
    protected Long montoIva10;

    @Column(name = "monto_iva5", nullable = false)
    protected Long montoIva5;

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
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "vencimiento_timbrado", nullable = false)
    protected LocalDateTime vencimientoTimbrado;

    public LocalDateTime getVencimientoTimbrado() {
        return vencimientoTimbrado;
    }

    public void setVencimientoTimbrado(LocalDateTime vencimientoTimbrado) {
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

    public Long getMontoIva5() {
        return montoIva5;
    }

    public void setMontoIva5(Long montoIva5) {
        this.montoIva5 = montoIva5;
    }

    public Long getMontoIva10() {
        return montoIva10;
    }

    public void setMontoIva10(Long montoIva10) {
        this.montoIva10 = montoIva10;
    }

    public Long getMontoExentas() {
        return montoExentas;
    }

    public void setMontoExentas(Long montoExentas) {
        this.montoExentas = montoExentas;
    }

    public Long getIva5() {
        return iva5;
    }

    public void setIva5(Long iva5) {
        this.iva5 = iva5;
    }

    public Long getIva10() {
        return iva10;
    }

    public void setIva10(Long iva10) {
        this.iva10 = iva10;
    }

    public com.haulmont.cuba.security.entity.User getIdUser() {
        return idUser;
    }

    public void setIdUser(com.haulmont.cuba.security.entity.User idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }
}