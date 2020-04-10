package org.mg.mgweb.web.informes;

import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.screen.*;
import org.mg.mgweb.entity.TblCentrosDeCosto;
import org.mg.mgweb.service.InformesService;

import javax.inject.Inject;
import java.util.Date;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import static org.mg.mgweb.service.InformesService.ReportFileFormatEnum.*;

@UiController("mgweb_InformesContabilidadScreen")
@UiDescriptor("informes-contabilidad-screen.xml")
@LoadDataBeforeShow
public class InformesContabilidadScreen extends Screen {

    @Inject
    private LookupField<Integer> lookupPickerFieldPeriodo;
    @Inject
    private DateField<Date> dateFieldHasta;
    @Inject
    private DateField<Date> dateFieldDesde;
    @Inject
    private InformesService informesService;
    @Inject
    Screens screens;
    @Inject
    ExportDisplay exportDisplay;
    @Inject
    private LookupPickerField<TblCentrosDeCosto> lookupPickerFieldCentroDeCosto;
    @Inject
    private CheckBox checkBoxCtaCteDetalle;
    @Inject
    private LookupPickerField<TblCentrosDeCosto> lookupPickerFieldCentroDeCostoMayor;
    @Inject
    private CheckBox checkBoxLibroMayorTotales;
    @Inject
    private CheckBox checkBoxLibroEgresosCdC;
    @Inject
    private LookupField lookupPickerFieldSaldos;

    @Subscribe
    public void onInit(InitEvent event) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("A\u00f1o actual", 1);
        map.put("Mes actual", 2);
        map.put("Hoy", 3);
        map.put("A\u00f1o anterior", 4);
        lookupPickerFieldPeriodo.setOptionsMap(map);
        lookupPickerFieldPeriodo.setValue(2);

        dateFieldDesde.setValue(Date.from(LocalDate.of(2016, 01, 01).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        dateFieldHasta.setValue(Date.from(LocalDate.of(2016, 12, 31).atStartOfDay(ZoneId.systemDefault()).plusDays(1).minusSeconds(1).toInstant()));

        Map<String, Integer> mapSaldos = new LinkedHashMap<>();
        mapSaldos.put("Externos", 1);
        mapSaldos.put("Internos", 2);
        mapSaldos.put("Todos", 3);
        lookupPickerFieldSaldos.setOptionsMap(mapSaldos);
        lookupPickerFieldSaldos.setValue(3);
    }

    @Subscribe("lookupPickerFieldPeriodo")
    public void onLookupPickerFieldPeriodoValueChange(HasValue.ValueChangeEvent event) {
        switch ((Integer) lookupPickerFieldPeriodo.getValue()) {
            case 1:
                dateFieldDesde.setValue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).withDayOfYear(1).toInstant()));
                dateFieldHasta.setValue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).plusDays(1).minusSeconds(1).toInstant()));
                break;
            case 2:
                dateFieldDesde.setValue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).withDayOfMonth(1).toInstant()));
                dateFieldHasta.setValue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).plusDays(1).minusSeconds(1).toInstant()));
                break;
            case 3:
                dateFieldDesde.setValue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant()));
                dateFieldHasta.setValue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).plusDays(1).minusSeconds(1).toInstant()));
                break;
            case 4:
                dateFieldDesde.setValue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).withDayOfYear(1).minusYears(1).toInstant()));
                dateFieldHasta.setValue(Date.from(LocalDate.now().atStartOfDay(ZoneId.systemDefault()).withDayOfYear(1).minusSeconds(1).toInstant()));
                break;
            default:
                break;
        }
    }

    public void onBtnCtaCteDetalleClick() {
        generarInformesCtaCteDetalle(HTML);
    }

    public void onBtnCtaCteDetallePDFClick(Component source) {
        generarInformesCtaCteDetalle(PDF);
    }

    public void onBtnCtaCteDetalleXLSXClick(Component source) {
        generarInformesCtaCteDetalle(XLSX);
    }

    private void generarInformesCtaCteDetalle(InformesService.ReportFileFormatEnum fileFormatEnum) {
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Extracto de Cuenta Corriente");
        paramsMap.put("fechaDesde", Timestamp.from(dateFieldDesde.getValue().toInstant()));
        paramsMap.put("fechaHasta", Timestamp.from(dateFieldHasta.getValue().toInstant()));
        if (lookupPickerFieldCentroDeCosto.getValue() != null) {
            paramsMap.put("centroDeCosto", lookupPickerFieldCentroDeCosto.getValue().getId().intValue());
            paramsMap.put("centroDeCostoNombre", lookupPickerFieldCentroDeCosto.getValue().getDescripcion());
        }
        if (checkBoxCtaCteDetalle.isChecked()) {
            if (lookupPickerFieldCentroDeCosto.getValue() != null) {
                generarInforme("extracto_ctacte_cc", "extracto_ctacte_subreport_saldo_anterior_cc", fileFormatEnum, paramsMap, false);
            } else {
                generarInforme("extracto_ctacte", "extracto_ctacte_subreport_saldo_anterior", fileFormatEnum, paramsMap, false);
            }
        } else {
            if (lookupPickerFieldCentroDeCosto.getValue() != null) {
                generarInforme("extracto_ctacte_resumen_cc", "extracto_ctacte_subreport_saldo_anterior_cc", fileFormatEnum, paramsMap, false);
            } else {
                generarInforme("extracto_ctacte_resumen", "extracto_ctacte_subreport_saldo_anterior", fileFormatEnum, paramsMap, false);
            }
        }

    }

    public void onBtnLibroMayorClick() {
        generarInformesLibroMayor(HTML);
    }

    public void onBtnLibroMayorPDFClick(Component source) {
        generarInformesLibroMayor(PDF);
    }

    public void onBtnLibroMayorXLSXClick(Component source) {
        generarInformesLibroMayor(XLSX);
    }

    private void generarInformesLibroMayor(InformesService.ReportFileFormatEnum fileFormatEnum) {
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Libro Mayor");
        paramsMap.put("fechaDesde", Timestamp.from(dateFieldDesde.getValue().toInstant()));
        paramsMap.put("fechaHasta", Timestamp.from(dateFieldHasta.getValue().toInstant()));
        if (lookupPickerFieldCentroDeCostoMayor.getValue() != null) {
            paramsMap.put("centroDeCosto", lookupPickerFieldCentroDeCostoMayor.getValue().getId().intValue());
            paramsMap.put("centroDeCostoNombre", lookupPickerFieldCentroDeCostoMayor.getValue().getDescripcion());
        }
        if (checkBoxLibroMayorTotales.isChecked()) {
            if (lookupPickerFieldCentroDeCosto.getValue() != null) {
                generarInforme("libro_mayor_solo_totales_cc", "libro_mayor_solo_totales_subreport_cc", "libro_mayor_solo_totales_subreport_saldo_anterior_cc", fileFormatEnum, paramsMap, false);
            } else {
                generarInforme("libro_mayor_solo_totales", "libro_mayor_solo_totales_subreport", "libro_mayor_solo_totales_subreport_saldo_anterior", fileFormatEnum, paramsMap, false);
            }
        } else {
            if (lookupPickerFieldCentroDeCosto.getValue() != null) {
                generarInforme("libro_mayor_cc", "libro_mayor_subreport_cc", "libro_mayor_subreport_saldo_anterior_cc", fileFormatEnum, paramsMap, false);
            } else {
                generarInforme("libro_mayor", "libro_mayor_subreport", "libro_mayor_subreport_saldo_anterior", fileFormatEnum, paramsMap, false);
            }
        }
    }

    public void onBtnLibroEgresosClick() {
        generarInformesLibroEgresos(HTML);
    }

    public void onBtnLibroEgresosPDFClick(Component source) {
        generarInformesLibroEgresos(PDF);
    }

    public void onBtnLibroEgresosXLSXClick(Component source) {
        generarInformesLibroEgresos(XLSX);
    }

    private void generarInformesLibroEgresos(InformesService.ReportFileFormatEnum fileFormatEnum) {
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Libro Egresos");
        paramsMap.put("fechaDesde", Timestamp.from(dateFieldDesde.getValue().toInstant()));
        paramsMap.put("fechaHasta", Timestamp.from(dateFieldHasta.getValue().toInstant()));

        if (checkBoxLibroEgresosCdC.isChecked()) {
            generarInforme("libro_egresos_cdc_cc", fileFormatEnum, paramsMap, true);
        } else {
            generarInforme("libro_egresos", fileFormatEnum, paramsMap, true);
        }
    }

    public void onBtnLibroIngresosClick() {
        generarInformesLibroIngresos(HTML);
    }

    public void onBtnLibroIngresosPDFClick(Component source) {
        generarInformesLibroIngresos(PDF);
    }

    public void onBtnLibroIngresosXLSXClick(Component source) {
        generarInformesLibroIngresos(XLSX);
    }

    private void generarInformesLibroIngresos(InformesService.ReportFileFormatEnum fileFormatEnum) {
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Libro Ingresos");
        paramsMap.put("fechaDesde", Timestamp.from(dateFieldDesde.getValue().toInstant()));
        paramsMap.put("fechaHasta", Timestamp.from(dateFieldHasta.getValue().toInstant()));

        generarInforme("libro_ingresos", fileFormatEnum, paramsMap, true);
    }

    public void onBtnIvaSemestralClick() {
        generarInformesIvaSemestral(HTML);
    }

    public void onBtnIvaSemestralPDFClick(Component source) {
        generarInformesIvaSemestral(PDF);
    }

    public void onBtnIvaSemestralXLSXClick(Component source) {
        generarInformesIvaSemestral(XLSX);
    }

    private void generarInformesIvaSemestral(InformesService.ReportFileFormatEnum fileFormatEnum) {
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "DDJJ IVA Semestral");
        paramsMap.put("fechaDesde", Timestamp.from(dateFieldDesde.getValue().toInstant()));
        paramsMap.put("fechaHasta", Timestamp.from(dateFieldHasta.getValue().toInstant()));

        generarInforme("ddjj-121", fileFormatEnum, paramsMap, false);
    }

    public void onBtnFacturasCreditoClick() {
        generarInformesFacturasCredito(HTML);
    }

    public void onBtnFacturasCreditoPDFClick(Component source) {
        generarInformesFacturasCredito(PDF);
    }

    public void onBtnFacturasCreditoXLSXClick(Component source) {
        generarInformesFacturasCredito(XLSX);
    }

    private void generarInformesFacturasCredito(InformesService.ReportFileFormatEnum fileFormatEnum) {
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Facturas Credito - Resumen");
        paramsMap.put("fechaDesde", Timestamp.from(dateFieldDesde.getValue().toInstant()));
        paramsMap.put("fechaHasta", Timestamp.from(dateFieldHasta.getValue().toInstant()));

        generarInforme("facturas_credito_resumen", fileFormatEnum, paramsMap, false);
    }

    public void onBtnSaldosCentroCostoClick() {
        generarInformesSaldosCentroCosto(HTML);
    }

    public void onBtnSaldosCentroCostoPDFClick(Component source) {
        generarInformesSaldosCentroCosto(PDF);
    }

    public void onBtnSaldosCentroCostoXLSXClick(Component source) {
        generarInformesSaldosCentroCosto(XLSX);
    }

    private void generarInformesSaldosCentroCosto(InformesService.ReportFileFormatEnum fileFormatEnum) {
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Extracto de Cuenta Corriente - Saldos");
        paramsMap.put("fechaDesde", Timestamp.from(dateFieldDesde.getValue().toInstant()));
        paramsMap.put("fechaHasta", Timestamp.from(dateFieldHasta.getValue().toInstant()));

        switch ((Integer) lookupPickerFieldSaldos.getValue()) {
            case 1:
                generarInforme("extracto_ctacte_saldos_cc_externos", "extracto_ctacte_saldos_subreport", "extracto_ctacte_saldos_subreport_saldo_anterior", fileFormatEnum, paramsMap, false);
                break;
            case 2:
                generarInforme("extracto_ctacte_saldos_cc_internos", "extracto_ctacte_saldos_subreport", "extracto_ctacte_saldos_subreport_saldo_anterior", fileFormatEnum, paramsMap, false);
                break;
            case 3:
                generarInforme("extracto_ctacte_saldos", "extracto_ctacte_saldos_subreport", "extracto_ctacte_saldos_subreport_saldo_anterior", fileFormatEnum, paramsMap, false);
                break;
        }
    }

    private void generarInforme(String reportFileName,
                                String subReportFileName,
                                String subSubReportFileName,
                                InformesService.ReportFileFormatEnum fileFormatEnum,
                                Map paramsMap,
                                Boolean landscape) {
        generarInforme(informesService.generarInforme(reportFileName,
                subReportFileName,
                subSubReportFileName,
                fileFormatEnum,
                paramsMap,
                null,
                landscape), fileFormatEnum);
    }

    private void generarInforme(String reportFileName,
                                String subReportFileName,
                                InformesService.ReportFileFormatEnum fileFormatEnum,
                                Map paramsMap,
                                Boolean landscape) {
        generarInforme(informesService.generarInforme(reportFileName,
                subReportFileName,
                fileFormatEnum,
                paramsMap,
                null,
                landscape), fileFormatEnum);
    }

    private void generarInforme(String reportFileName,
                                InformesService.ReportFileFormatEnum fileFormatEnum,
                                Map paramsMap,
                                Boolean landscape) {
        generarInforme(informesService.generarInforme(reportFileName,
                fileFormatEnum,
                paramsMap,
                null,
                landscape), fileFormatEnum);
    }

    private void generarInforme(Map params, InformesService.ReportFileFormatEnum fileFormatEnum) {
        if (fileFormatEnum == HTML) {
            Screenreport screen = screens.create(Screenreport.class, OpenMode.NEW_WINDOW);
            screen.setParams(params);
            screen.show();
        } else {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");
            exportDisplay.show(new ByteArrayDataProvider((byte[]) params.get("reportParam")),
                    params.get("fileName").toString(),
                    ExportFormat.getByExtension(fileFormatEnum.name().toLowerCase()));
        }
    }

}