package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@DesignSupport("{'imported':true}")
@Table(name = "tbl_evento_detalle")
@Entity(name = "mgweb_TblEventoDetalle")
public class TblEventoDetalle extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -4135630218631220565L;
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fechahora", nullable = false)
    protected Date fechahora;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_categoria_articulo")
    protected TblCategoriasArticulos idCategoriaArticulo;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entidad")
    protected TblEntidades idEntidad;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_evento")
    protected org.mg.mgweb.entity.TblEventos idEvento;
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_forma_de_pago_preferida")
    protected org.mg.mgweb.entity.TblFormasDePago idFormaDePagoPreferida;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_user")
    protected org.mg.mgweb.entity.TblUsers idUser;
    @Column(name = "monto", nullable = false)
    protected Integer monto;
    @Column(name = "observacion")
    protected String observacion;
    @JoinTable(name = "tbl_evento_detalle_asientos",
            joinColumns = @JoinColumn(name = "id_evento_detalle"),
            inverseJoinColumns = @JoinColumn(name = "id_asiento"))
    @ManyToMany
    protected List<TblAsientos> tblAsientos;

    public List<TblAsientos> getTblAsientos() {
        return tblAsientos;
    }

    public void setTblAsientos(List<TblAsientos> tblAsientos) {
        this.tblAsientos = tblAsientos;
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

    public org.mg.mgweb.entity.TblUsers getIdUser() {
        return idUser;
    }

    public void setIdUser(org.mg.mgweb.entity.TblUsers idUser) {
        this.idUser = idUser;
    }

    public org.mg.mgweb.entity.TblFormasDePago getIdFormaDePagoPreferida() {
        return idFormaDePagoPreferida;
    }

    public void setIdFormaDePagoPreferida(org.mg.mgweb.entity.TblFormasDePago idFormaDePagoPreferida) {
        this.idFormaDePagoPreferida = idFormaDePagoPreferida;
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

    public TblCategoriasArticulos getIdCategoriaArticulo() {
        return idCategoriaArticulo;
    }

    public void setIdCategoriaArticulo(TblCategoriasArticulos idCategoriaArticulo) {
        this.idCategoriaArticulo = idCategoriaArticulo;
    }

    public Date getFechahora() {
        return fechahora;
    }

    public void setFechahora(Date fechahora) {
        this.fechahora = fechahora;
    }
}