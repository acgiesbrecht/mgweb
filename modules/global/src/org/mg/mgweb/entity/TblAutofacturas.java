package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@NamePattern("%s %s|idTimbrado,nro")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_autofacturas")
@Entity(name = "mgweb_TblAutofacturas")
public class TblAutofacturas extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -2476261124628181077L;

    @Column(name = "anulado")
    protected Boolean anulado;

    @Column(name = "cantidad", nullable = false)
    protected Integer cantidad;

    @Column(name = "ci", nullable = false, length = 20)
    protected String ci;

    @Column(name = "concepto", nullable = false)
    protected String concepto;

    @Column(name = "condicion_contado")
    protected Boolean condicionContado;

    @Column(name = "direccion_de_transaccion", nullable = false)
    protected String direccionDeTransaccion;

    @Column(name = "domicilio", nullable = false)
    protected String domicilio;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechahora", nullable = false)
    protected LocalDateTime fechahora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_timbrado")
    protected org.mg.mgweb.entity.TblTimbradosAutofacturas idTimbrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected com.haulmont.cuba.security.entity.User idUser;

    @Column(name = "monto", nullable = false)
    protected Long monto;

    @Column(name = "nombre", nullable = false)
    protected String nombre;

    @Column(name = "nro", nullable = false, length = 15)
    protected String nro;

    @Column(name = "observacion")
    protected String observacion;

    @Column(name = "precio_unitario", nullable = false)
    protected Integer precioUnitario;

    @JoinTable(name = "tbl_autofacturas_asientos",
            joinColumns = @JoinColumn(name = "id_autofactura"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento"))
    @ManyToMany
    protected List<TblAsientos> tblAsientos;

    public List<TblAsientos> getTblAsientos() {
        return tblAsientos;
    }

    public void setTblAsientos(List<TblAsientos> tblAsientos) {
        this.tblAsientos = tblAsientos;
    }

    public Integer getPrecioUnitario() {
        return precioUnitario;
    }

    public void setPrecioUnitario(Integer precioUnitario) {
        this.precioUnitario = precioUnitario;
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

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Long getMonto() {
        return monto;
    }

    public void setMonto(Long monto) {
        this.monto = monto;
    }

    public com.haulmont.cuba.security.entity.User getIdUser() {
        return idUser;
    }

    public void setIdUser(com.haulmont.cuba.security.entity.User idUser) {
        this.idUser = idUser;
    }

    public org.mg.mgweb.entity.TblTimbradosAutofacturas getIdTimbrado() {
        return idTimbrado;
    }

    public void setIdTimbrado(org.mg.mgweb.entity.TblTimbradosAutofacturas idTimbrado) {
        this.idTimbrado = idTimbrado;
    }

    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public String getDireccionDeTransaccion() {
        return direccionDeTransaccion;
    }

    public void setDireccionDeTransaccion(String direccionDeTransaccion) {
        this.direccionDeTransaccion = direccionDeTransaccion;
    }

    public Boolean getCondicionContado() {
        return condicionContado;
    }

    public void setCondicionContado(Boolean condicionContado) {
        this.condicionContado = condicionContado;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    public String getCi() {
        return ci;
    }

    public void setCi(String ci) {
        this.ci = ci;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }
}