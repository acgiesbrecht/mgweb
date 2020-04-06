package org.mg.mgweb.web.informes;

import com.haulmont.cuba.gui.Screens;
import com.haulmont.cuba.gui.components.Component;
import com.haulmont.cuba.gui.components.LookupPickerField;
import com.haulmont.cuba.gui.export.ByteArrayDataProvider;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.screen.*;
import org.mg.mgweb.entity.TblEntidades;
import org.mg.mgweb.entity.TblEventos;
import org.mg.mgweb.service.InformesService;

import javax.inject.Inject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import static org.mg.mgweb.service.InformesService.ReportFileFormatEnum.*;

@UiController("mgweb_InformesRematesScreen")
@UiDescriptor("informes-remates-screen.xml")
@LoadDataBeforeShow
public class InformesRematesScreen extends Screen {

    @Inject
    private InformesService informesService;
    @Inject
    Screens screens;
    @Inject
    ExportDisplay exportDisplay;
    @Inject
    private LookupPickerField<TblEventos> lookupPickerFieldEventos;
    @Inject
    private LookupPickerField<TblEntidades> lookupPickerFieldEntidades;

    public void onBtnDetalleComprasClick() {
        generarInformesDetalleCompras(HTML);
    }

    public void onBtnDetalleComprasPDFClick(Component source) {
        generarInformesDetalleCompras(PDF);
    }

    public void onBtnDetalleComprasXLSXClick(Component source) {
        generarInformesDetalleCompras(XLSX);
    }

    private void generarInformesDetalleCompras(InformesService.ReportFileFormatEnum fileFormatEnum) {
        lookupPickerFieldEventos.validate();
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Informes de Detalle Compras - Remates");
        paramsMap.put("id_evento", (lookupPickerFieldEventos.getValue()).getId().intValue());

        generarInforme("remate_detalle", fileFormatEnum, paramsMap);
    }

    public void onBtnTransferenciasPendientesClick(){
        generarInformesTransferenciasPendientes(HTML);
    }
    public void onBtnTransferenciasPendientesPDFClick(Component source) {
        generarInformesDetalleCompras(PDF);
    }

    public void onBtnTransferenciasPendientesXLSXClick(Component source) {
        generarInformesTransferenciasPendientes(XLSX);
    }

    private void generarInformesTransferenciasPendientes(InformesService.ReportFileFormatEnum fileFormatEnum) {
        lookupPickerFieldEventos.validate();
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Informes de Transferencias Pendientes - Remates");
        paramsMap.put("id_evento", (lookupPickerFieldEventos.getValue()).getId().intValue());

        generarInforme("remate_transferencias_pendientes_de_firma", fileFormatEnum, paramsMap);
    }

    public void onBtnTransferenciasFirmadasClick(){
        generarInformesTransferenciasFirmadas(HTML);
    }
    public void onBtnTransferenciasFirmadasPDFClick(Component source) {
        generarInformesTransferenciasFirmadas(PDF);
    }

    public void onBtnTransferenciasFirmadasXLSXClick(Component source) {
        generarInformesTransferenciasFirmadas(XLSX);
    }

    private void generarInformesTransferenciasFirmadas(InformesService.ReportFileFormatEnum fileFormatEnum) {
        lookupPickerFieldEventos.validate();
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Informes de Transferencias Firmadas - Remates");
        paramsMap.put("id_evento", (lookupPickerFieldEventos.getValue()).getId().intValue());

        generarInforme("remate_detalle_transferencias", fileFormatEnum, paramsMap);
    }

    public void onBtnPagosEfectivoClick(){
        generarInformesPagosEfectivo(HTML);
    }
    public void onBtnPagosEfectivoPDFClick(Component source) {
        generarInformesPagosEfectivo(PDF);
    }

    public void onBtnPagosEfectivoXLSXClick(Component source) {
        generarInformesPagosEfectivo(XLSX);
    }

    private void generarInformesPagosEfectivo(InformesService.ReportFileFormatEnum fileFormatEnum) {
        lookupPickerFieldEventos.validate();
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Informes de Pagos en efectivo - Remates");
        paramsMap.put("id_evento", (lookupPickerFieldEventos.getValue()).getId().intValue());

        generarInforme("remate_detalle_recibos", fileFormatEnum, paramsMap);
    }

    public void onBtnPagosResumenClick(){
        generarInformesPagosResumen(HTML);
    }
    public void onBtnPagosResumenPDFClick(Component source) {
        generarInformesPagosResumen(PDF);
    }

    public void onBtnPagosResumenXLSXClick(Component source) {
        generarInformesPagosResumen(XLSX);
    }

    private void generarInformesPagosResumen(InformesService.ReportFileFormatEnum fileFormatEnum) {
        lookupPickerFieldEventos.validate();
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Resumen de Pagos - Remates");
        paramsMap.put("id_evento", (lookupPickerFieldEventos.getValue()).getId().intValue());

        generarInforme("remate_detalle_recibos", fileFormatEnum, paramsMap);
    }

    public void onBtnComprasClienteClick(){
        generarInformesComprasCliente(HTML);
    }
    public void onBtnComprasClientePDFClick(Component source) {
        generarInformesComprasCliente(PDF);
    }

    public void onBtnComprasClienteXLSXClick(Component source) {
        generarInformesComprasCliente(XLSX);
    }

    private void generarInformesComprasCliente(InformesService.ReportFileFormatEnum fileFormatEnum) {
        lookupPickerFieldEventos.validate();
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Compras por Cliente - Remates");
        paramsMap.put("id_evento", (lookupPickerFieldEventos.getValue()).getId().intValue());
        paramsMap.put("id_miembro", (lookupPickerFieldEntidades.getValue()).getId().intValue());

        generarInforme("remate_detalle_compras_miembro", fileFormatEnum, paramsMap);
    }

    public void onBtnPagosClienteClick(){
        generarInformesPagosCliente(HTML);
    }
    public void onBtnPagosClientePDFClick(Component source) {
        generarInformesPagosCliente(PDF);
    }

    public void onBtnPagosClienteXLSXClick(Component source) {
        generarInformesPagosCliente(XLSX);
    }

    private void generarInformesPagosCliente(InformesService.ReportFileFormatEnum fileFormatEnum) {
        lookupPickerFieldEventos.validate();
        Map<String, Object> paramsMap = new HashMap<>();

        paramsMap.put("reportScreenCaption", "Compras por Cliente - Remates");
        paramsMap.put("id_evento", (lookupPickerFieldEventos.getValue()).getId().intValue());
        paramsMap.put("id_miembro", (lookupPickerFieldEntidades.getValue()).getId().intValue());

        generarInforme("remate_detalle_pagos_miembro", fileFormatEnum, paramsMap);
    }
    
    private void generarInforme(String reportFileName,
                   InformesService.ReportFileFormatEnum fileFormatEnum,
                   Map paramsMap){
        Map params = informesService.generarInforme(reportFileName,
                fileFormatEnum,
                paramsMap,
                null);
        if(fileFormatEnum == HTML) {
            Screenreport screen = screens.create(Screenreport.class, OpenMode.NEW_WINDOW);
            screen.setParams(params);
            screen.show();
        }else {
            DateTimeFormatter df = DateTimeFormatter.ofPattern("yyyy-MM-dd-HHmmss");
            exportDisplay.show(new ByteArrayDataProvider((byte[])params.get("reportParam")),
                    params.get("fileName").toString(),
                    ExportFormat.getByExtension(fileFormatEnum.name().toLowerCase()));
        }
    }

}