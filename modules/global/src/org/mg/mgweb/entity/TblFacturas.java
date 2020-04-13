package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntegerIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;
import java.util.List;

@NamePattern("%s %s %s|id,idTimbrado,fechahora")
@DesignSupport("{'imported':true}")
@AttributeOverrides({
        @AttributeOverride(name = "id", column = @Column(name = "nro"))
})
@Table(name = "tbl_facturas")
@Entity(name = "mgweb_TblFacturas")
public class TblFacturas extends BaseIntegerIdEntity {
    private static final long serialVersionUID = 4899043112508632430L;

    @Column(name = "anulado")
    protected Boolean anulado;

    @Column(name = "casilla_de_correo")
    protected Integer casillaDeCorreo;

    @Column(name = "domicilio")
    protected String domicilio;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechahora", nullable = false)
    protected LocalDateTime fechahora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entidad")
    protected TblEntidades idEntidad;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_timbrado")
    protected org.mg.mgweb.entity.TblTimbrados idTimbrado;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected com.haulmont.cuba.security.entity.User idUser;

    @Column(name = "importe_aporte", nullable = false)
    protected Integer importeAporte;

    @Column(name = "importe_donacion", nullable = false)
    protected Integer importeDonacion;

    @Column(name = "razon_social", nullable = false, length = 50)
    protected String razonSocial;

    @Column(name = "ruc", nullable = false, length = 20)
    protected String ruc;

    @JoinTable(name = "tbl_facturas_asientos",
            joinColumns = @JoinColumn(name = "nro_factura"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblAsientos> tblAsientos;

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

    public Integer getImporteDonacion() {
        return importeDonacion;
    }

    public void setImporteDonacion(Integer importeDonacion) {
        this.importeDonacion = importeDonacion;
    }

    public Integer getImporteAporte() {
        return importeAporte;
    }

    public void setImporteAporte(Integer importeAporte) {
        this.importeAporte = importeAporte;
    }

    public com.haulmont.cuba.security.entity.User getIdUser() {
        return idUser;
    }

    public void setIdUser(com.haulmont.cuba.security.entity.User idUser) {
        this.idUser = idUser;
    }

    public org.mg.mgweb.entity.TblTimbrados getIdTimbrado() {
        return idTimbrado;
    }

    public void setIdTimbrado(org.mg.mgweb.entity.TblTimbrados idTimbrado) {
        this.idTimbrado = idTimbrado;
    }

    public TblEntidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(TblEntidades idEntidad) {
        this.idEntidad = idEntidad;
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

    public Integer getCasillaDeCorreo() {
        return casillaDeCorreo;
    }

    public void setCasillaDeCorreo(Integer casillaDeCorreo) {
        this.casillaDeCorreo = casillaDeCorreo;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }
}