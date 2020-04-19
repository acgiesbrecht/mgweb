package org.mg.mgweb.web.ingresos.tbleventodetalle;

import com.haulmont.cuba.core.entity.IdProxy;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.LoadContext;
import com.haulmont.cuba.core.global.Resources;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionLoader;
import com.haulmont.cuba.gui.model.DataContext;
import com.haulmont.cuba.gui.screen.*;
import com.haulmont.cuba.security.global.UserSession;
import org.mg.mgweb.entity.*;
import org.mg.mgweb.entity.enums.ModoImpresionTransferenciasEnum;
import org.mg.mgweb.entity.models.CuotaModel;
import org.mg.mgweb.service.InformesService;
import org.mg.mgweb.service.RematesService;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

@UiController("mgweb_RematesPagosScreen")
@UiDescriptor("remates-pagos-screen.xml")
public class RematesPagosScreen extends Screen {

    @Inject
    private LookupField<TblEventos> lookupFieldEvento;
    @Inject
    private RematesService rematesService;
    @Inject
    private LookupField<TblEntidades> lookupFieldEntidad;
    @Inject
    private CollectionLoader<TblEventoDetalle> tblEventoDetallesDl;
    @Inject
    private TextField<Long> textFieldPagosAnteriores;
    @Inject
    private TextField<Long> textFieldPagosTotal;
    @Inject
    private TextField<Long> textFieldPagosSaldo;
    @Inject
    private TextField<Long> textFieldImporteTransferencia;
    @Inject
    private TextField<Long> textFieldImporteRecibo;
    @Inject
    private RadioButtonGroup<Integer> radioButtonGroupTerminoPago;
    @Inject
    private DateField<Date> dateFieldPago;
    @Inject
    private Label<String> labelFechasCuotas;
    @Inject
    private Notifications notifications;
    @Inject
    private DataManager dataManager;
    @Inject
    private UserSession userSession;
    @Inject
    private Resources resources;
    @Inject
    private InformesService informesService;
    @Inject
    private ExportDisplay exportDisplay;
    @Inject
    private DataContext dataContext;
    @Inject
    private CollectionContainer<TblEventoDetalle> tblEventoDetallesDc;
    @Inject
    private GroupBoxLayout groupBoxPago;

    @Subscribe("lookupFieldEvento")
    public void onLookupFieldEventoValueChange(HasValue.ValueChangeEvent<TblEventos> event) {
        lookupFieldEntidad.setOptionsList(rematesService.getEntidadesConSaldo(lookupFieldEvento.getValue()));
    }

    @Subscribe("lookupFieldEntidad")
    public void onLookupFieldEntidadValueChange(HasValue.ValueChangeEvent event) {
        if (lookupFieldEntidad.getValue() == null) {
            tblEventoDetallesDc.setItems(null);
            groupBoxPago.setVisible(false);
            return;
        }
        tblEventoDetallesDl.setParameter("evento", lookupFieldEvento.getValue());
        tblEventoDetallesDl.setParameter("entidad", lookupFieldEntidad.getValue());
        tblEventoDetallesDl.load();
        textFieldPagosTotal.setValue(rematesService.getPagosTotal(lookupFieldEvento.getValue(), lookupFieldEntidad.getValue()));
        textFieldPagosAnteriores.setValue(rematesService.getPagosAnteriores(lookupFieldEvento.getValue(), lookupFieldEntidad.getValue()));
        textFieldPagosSaldo.setValue(textFieldPagosTotal.getValue() - textFieldPagosAnteriores.getValue());

        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("Pago unico: ", 1);
        map.put("Pago en cuotas: ", 2);
        radioButtonGroupTerminoPago.setOptionsMap(map);
        radioButtonGroupTerminoPago.setValue(1);

        dateFieldPago.setValue(new Date());
        labelFechasCuotas.setValue(rematesService.getFechasCuotas(lookupFieldEvento.getValue()));

        groupBoxPago.setVisible(true);
    }

    @Subscribe("radioButtonGroupTerminoPago")
    public void onRadioButtonGroupTerminoPagoValueChange(HasValue.ValueChangeEvent event) {
        if (radioButtonGroupTerminoPago.getValue() == 1) {
            dateFieldPago.setVisible(true);
            labelFechasCuotas.setVisible(false);
        } else {
            dateFieldPago.setVisible(false);
            labelFechasCuotas.setVisible(true);
        }
    }


    @Subscribe("textFieldPagosSaldo")
    public void onTextFieldPagosSaldoValueChange(HasValue.ValueChangeEvent<Long> event) {
        textFieldImporteTransferencia.setValue(textFieldPagosSaldo.getValue() != null ? textFieldPagosSaldo.getValue() : 0L);
    }

    @Subscribe("textFieldImporteRecibo")
    public void onTextFieldImporteReciboValueChange(HasValue.ValueChangeEvent<Long> event) {
        if (textFieldPagosSaldo.getValue() != null && textFieldImporteRecibo.getValue() != null) {
            textFieldImporteTransferencia.setValue(textFieldPagosSaldo.getValue() - textFieldImporteRecibo.getValue());
        }
    }


    public void procesar() {

        if (textFieldImporteTransferencia.getValue() == null) {
            textFieldImporteTransferencia.setValue(0L);
        }
        if (textFieldImporteRecibo.getValue() == null) {
            textFieldImporteRecibo.setValue(0L);
        }

        if (textFieldImporteTransferencia.getValue() + textFieldImporteRecibo.getValue() > textFieldPagosSaldo.getValue()) {
            notifications.create().withDescription("El importe de transferencia y recibo debe ser menor o igual al saldo a pagar!").show();
            return;
        }

        if (textFieldImporteTransferencia.getValue() > 0) {
            if (radioButtonGroupTerminoPago.getValue() == 1) {
                CuotaModel cuota= new CuotaModel();
                cuota.setFecha(dateFieldPago.getValue().toInstant().atZone(ZoneId.systemDefault()).toLocalDateTime());
                cuota.setMonto(textFieldImporteTransferencia.getValue());
                generarTransferencia(cuota);
            } else {
                List<CuotaModel> cuotasList = getCuotas(lookupFieldEvento.getValue(), textFieldImporteTransferencia.getValue());
                for (CuotaModel cuota : cuotasList) {
                    generarTransferencia(cuota);
                }
            }
        }

        cancelar();
    }

    private void generarTransferencia(CuotaModel cuota){
        int secuencia = (new Random()).nextInt(10000);
        TblTransferencias transferencia = dataManager.create(TblTransferencias.class);
        transferencia.setFechahora(cuota.getFecha());
        transferencia.setFechahoraCompromiso(cuota.getFecha());
        transferencia.setIdEntidad(lookupFieldEntidad.getValue());
        transferencia.setConcepto(lookupFieldEvento.getValue().getDescripcion());
        transferencia.setMontoAporte(cuota.getMonto().longValue() * (lookupFieldEvento.getValue().getPorcentajeAporte().longValue() / 100));
        transferencia.setMontoDonacion(cuota.getMonto() - transferencia.getMontoAporte());
        transferencia.setIdEventoTipo(lookupFieldEvento.getValue().getIdEventoTipo());
        transferencia.setIdEvento(lookupFieldEvento.getValue());
        transferencia.setCobrado(false);
        transferencia.setSeqPago(secuencia);
        transferencia.setIdUser(userSession.getUser());
        transferencia = dataManager.commit(transferencia);
        if (transferencia.getId().get() > 0) {
            Map params = informesService.generarTransferencia(transferencia.getId().get());
            //if (dataManager.load(TblConfiguraciones.class).id(IdProxy.of(1)).one().getModoImpresionTransferencias().equals(ModoImpresionTransferenciasEnum.NORMAL)) {
            exportDisplay.show(new ByteArrayDataProvider((byte[]) params.get("reportParam")),
                    params.get("fileName").toString(),
                    ExportFormat.getByExtension("pdf"));

                        /*} else {
                            for (Integer x = 1; x == 3; x++) {
                                informesService.generarInforme("transferencia_simple", InformesService.ReportFileFormatEnum.PDF, parameters,null,false);
                            }
                        }*/
        }
    }

    public void cancelar() {
        lookupFieldEntidad.setValue(null);
        lookupFieldEntidad.focus();
    }

    private List<CuotaModel> getCuotas(TblEventos evento, Long monto) {
        List<LocalDateTime> fechasList = new ArrayList<>();
        TblEventoCuotas eventoCuotas = dataManager.load(TblEventoCuotas.class)
                .query("select e from mgweb_TblEventoCuotas e where e.id = " + evento.getId().get()).one();
        if (eventoCuotas.getFecha1() != null) {
            fechasList.add(eventoCuotas.getFecha1());
        }
        if (eventoCuotas.getFecha2() != null) {
            fechasList.add(eventoCuotas.getFecha2());
        }
        if (eventoCuotas.getFecha3() != null) {
            fechasList.add(eventoCuotas.getFecha3());
        }
        if (eventoCuotas.getFecha4() != null) {
            fechasList.add(eventoCuotas.getFecha4());
        }

        List<CuotaModel> listCuotas = new ArrayList<>();
        double divi = monto * 1.0 / fechasList.size();
        Long montoCuota = Math.round(divi);
        for (LocalDateTime fecha : fechasList) {
            CuotaModel cuota = new CuotaModel();
            cuota.setFecha(fecha);
            cuota.setMonto(montoCuota);
            listCuotas.add(cuota);
        }
        if (montoCuota * fechasList.size() > monto) {
            CuotaModel cuota = new CuotaModel();
            cuota.setFecha(listCuotas.get(listCuotas.size() - 1).getFecha());
            cuota.setMonto(montoCuota - 1);
            listCuotas.set(listCuotas.size() - 1, cuota);
        } else if (montoCuota * fechasList.size() < monto) {
            CuotaModel cuota = new CuotaModel();
            cuota.setFecha(listCuotas.get(listCuotas.size() - 1).getFecha());
            cuota.setMonto(montoCuota + 1);
            listCuotas.set(listCuotas.size() - 1, cuota);
        }

        return listCuotas;
    }

}