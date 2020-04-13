package org.mg.mgweb.entity;

import com.haulmont.cuba.core.entity.BaseIntIdentityIdEntity;
import org.mg.mgweb.entity.enums.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Table(name = "TBL_CONFIGURACIONES")
@Entity(name = "mgweb_TblConfiguraciones")
public class TblConfiguraciones extends BaseIntIdentityIdEntity {
    private static final long serialVersionUID = 8850451694500118971L;

    @Column(name = "PERIODO_FISCAL_ACTIVO")
    protected Integer periodoFiscalActivo = LocalDate.now().getYear();

    @NotNull
    @Column(name = "FORMATO_FACTURA", nullable = false)
    protected String formatoFactura;

    @NotNull
    @Column(name = "FORMATO_AUTOFACTURA", nullable = false)
    protected String formatoAutofactura;

    @NotNull
    @Column(name = "FORMATO_NOTA_DE_CREDITO", nullable = false)
    protected String formatoNotaDeCredito;

    @NotNull
    @Column(name = "FRECUENCIA_COBRO_COLECTAS", nullable = false)
    protected Integer frecuenciaCobroColectas = 1;

    @NotNull
    @Column(name = "MODO_IMPRESION_TRANSFERENCIAS", nullable = false)
    protected Integer modoImpresionTransferencias = 1;

    public ModoImpresionTransferenciasEnum getModoImpresionTransferencias() {
        return modoImpresionTransferencias == null ? null : ModoImpresionTransferenciasEnum.fromId(modoImpresionTransferencias);
    }

    public void setModoImpresionTransferencias(ModoImpresionTransferenciasEnum modoImpresionTransferencias) {
        this.modoImpresionTransferencias = modoImpresionTransferencias == null ? null : modoImpresionTransferencias.getId();
    }

    public FrecuenciaCobroColectasEnum getFrecuenciaCobroColectas() {
        return frecuenciaCobroColectas == null ? null : FrecuenciaCobroColectasEnum.fromId(frecuenciaCobroColectas);
    }

    public void setFrecuenciaCobroColectas(FrecuenciaCobroColectasEnum frecuenciaCobroColectas) {
        this.frecuenciaCobroColectas = frecuenciaCobroColectas == null ? null : frecuenciaCobroColectas.getId();
    }

    public NotaDeCreditoLayoutEnum getFormatoNotaDeCredito() {
        return formatoNotaDeCredito == null ? null : NotaDeCreditoLayoutEnum.fromId(formatoNotaDeCredito);
    }

    public void setFormatoNotaDeCredito(NotaDeCreditoLayoutEnum formatoNotaDeCredito) {
        this.formatoNotaDeCredito = formatoNotaDeCredito == null ? null : formatoNotaDeCredito.getId();
    }

    public AutofacturaLayoutEnum getFormatoAutofactura() {
        return formatoAutofactura == null ? null : AutofacturaLayoutEnum.fromId(formatoAutofactura);
    }

    public void setFormatoAutofactura(AutofacturaLayoutEnum formatoAutofactura) {
        this.formatoAutofactura = formatoAutofactura == null ? null : formatoAutofactura.getId();
    }

    public FacturaLayoutEnum getFormatoFactura() {
        return formatoFactura == null ? null : FacturaLayoutEnum.fromId(formatoFactura);
    }

    public void setFormatoFactura(FacturaLayoutEnum formatoFactura) {
        this.formatoFactura = formatoFactura == null ? null : formatoFactura.getId();
    }

    public Integer getPeriodoFiscalActivo() {
        return periodoFiscalActivo;
    }

    public void setPeriodoFiscalActivo(Integer periodoFiscalActivo) {
        this.periodoFiscalActivo = periodoFiscalActivo;
    }
}