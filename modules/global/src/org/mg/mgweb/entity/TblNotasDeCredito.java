package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.time.LocalDateTime;
import org.mg.mgweb.converters.LocalDateTimeAttributeConverter;
import java.util.List;

@NamePattern("%s %s|nro,idTimbrado")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_notas_de_credito")
@Entity(name = "mgweb_TblNotasDeCredito")
public class TblNotasDeCredito extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 9069454120899233995L;

    @Column(name = "anulado")
    protected Boolean anulado;

    @Temporal(TemporalType.TIMESTAMP)
    @Convert(converter = LocalDateTimeAttributeConverter.class)
    @Column(name = "fechahora", nullable = false)
    protected LocalDateTime fechahora;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_timbrado")
    protected org.mg.mgweb.entity.TblTimbradosNotasDeCredito idTimbrado;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_user")
    protected org.mg.mgweb.entity.TblUsers idUser;

    @Column(name = "nro", nullable = false, length = 15)
    protected String nro;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "nro_factura")
    protected org.mg.mgweb.entity.TblFacturas nroFactura;

    @JoinTable(name = "tbl_notas_de_credito_asientos",
            joinColumns = @JoinColumn(name = "id_nota_de_credito"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento"))
    @ManyToMany
    protected List<org.mg.mgweb.entity.TblAsientos> tblAsientos;

    public List<org.mg.mgweb.entity.TblAsientos> getTblAsientos() {
        return tblAsientos;
    }

    public void setTblAsientos(List<org.mg.mgweb.entity.TblAsientos> tblAsientos) {
        this.tblAsientos = tblAsientos;
    }

    public org.mg.mgweb.entity.TblFacturas getNroFactura() {
        return nroFactura;
    }

    public void setNroFactura(org.mg.mgweb.entity.TblFacturas nroFactura) {
        this.nroFactura = nroFactura;
    }

    public String getNro() {
        return nro;
    }

    public void setNro(String nro) {
        this.nro = nro;
    }

    public org.mg.mgweb.entity.TblUsers getIdUser() {
        return idUser;
    }

    public void setIdUser(org.mg.mgweb.entity.TblUsers idUser) {
        this.idUser = idUser;
    }

    public org.mg.mgweb.entity.TblTimbradosNotasDeCredito getIdTimbrado() {
        return idTimbrado;
    }

    public void setIdTimbrado(org.mg.mgweb.entity.TblTimbradosNotasDeCredito idTimbrado) {
        this.idTimbrado = idTimbrado;
    }

    public LocalDateTime getFechahora() {
        return fechahora;
    }

    public void setFechahora(LocalDateTime fechahora) {
        this.fechahora = fechahora;
    }

    public Boolean getAnulado() {
        return anulado;
    }

    public void setAnulado(Boolean anulado) {
        this.anulado = anulado;
    }
}