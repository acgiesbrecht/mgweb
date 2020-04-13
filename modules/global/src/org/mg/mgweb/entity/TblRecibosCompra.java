package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;
import com.haulmont.cuba.security.entity.User;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamePattern("%s %s|nro,fechahora")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_recibos_compra")
@Entity(name = "mgweb_TblRecibosCompra")
public class TblRecibosCompra extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 9023629100470374054L;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechahora", nullable = false)
    protected LocalDateTime fechahora;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected User idUser;

    @Column(name = "monto", nullable = false)
    protected Long monto;

    @Column(name = "nro", nullable = false, length = 30)
    protected String nro;

    @Column(name = "observacion")
    protected String observacion;

    @Column(name = "razon_social", nullable = false)
    protected String razonSocial;

    @Column(name = "ruc", nullable = false, length = 20)
    protected String ruc;

    @JoinTable(name = "tbl_recibos_compra_asientos",
            joinColumns = @JoinColumn(name = "id_recibo"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento"))
    @ManyToMany
    protected List<TblAsientos> tblAsientos;

    @JoinTable(name = "tbl_recibos_compra_facturas_compra",
            joinColumns = @JoinColumn(name = "id_recibo"),
            inverseJoinColumns = @JoinColumn(name = "id_factura_compra"))
    @ManyToMany
    protected List<TblFacturasCompra> tblFacturasCompra;

    public List<TblFacturasCompra> getTblFacturasCompra() {
        return tblFacturasCompra;
    }

    public void setTblFacturasCompra(List<TblFacturasCompra> tblFacturasCompra) {
        this.tblFacturasCompra = tblFacturasCompra;
    }

    public List<TblAsientos> getTblAsientos() {
        return tblAsientos;
    }

    public void setTblAsientos(List<TblAsientos> tblAsientos) {
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

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public User getIdUser() {
        return idUser;
    }

    public void setIdUser(User idUser) {
        this.idUser = idUser;
    }

    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }
}