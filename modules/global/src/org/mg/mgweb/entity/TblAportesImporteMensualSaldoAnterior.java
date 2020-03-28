package org.mg.mgweb.entity;

import com.haulmont.chile.core.annotations.NamePattern;
import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import com.haulmont.cuba.core.global.DesignSupport;

import javax.persistence.*;

@NamePattern("%s %s %s|ano,idEntidad,importeMesnual")
@DesignSupport("{'imported':true}")
@Table(name = "tbl_aportes_importe_mensual_saldo_anterior")
@Entity(name = "mgweb_TblAportesImporteMensualSaldoAnterior")
public class TblAportesImporteMensualSaldoAnterior extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = -4120861049996424861L;

    @Column(name = "ano", nullable = false)
    protected Integer ano;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "id_entidad")
    protected TblEntidades idEntidad;

    @Column(name = "importe_mesnual", nullable = false)
    protected Long importeMesnual;

    @Column(name = "saldo_anterior", nullable = false)
    protected Long saldoAnterior;

    public Long getSaldoAnterior() {
        return saldoAnterior;
    }

    public void setSaldoAnterior(Long saldoAnterior) {
        this.saldoAnterior = saldoAnterior;
    }

    public Long getImporteMesnual() {
        return importeMesnual;
    }

    public void setImporteMesnual(Long importeMesnual) {
        this.importeMesnual = importeMesnual;
    }

    public TblEntidades getIdEntidad() {
        return idEntidad;
    }

    public void setIdEntidad(TblEntidades idEntidad) {
        this.idEntidad = idEntidad;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }
}