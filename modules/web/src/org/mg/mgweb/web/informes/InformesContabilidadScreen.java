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

    @Subscribe
    public void onInit(InitEvent event) {
        Map<String, Integer> map = new LinkedHashMap<>();
        map.put("A\u00f1o actual", 1);
        map.put("Mes actual", 2);
        map.put("Hoy", 3);
        map.put("A\u00f1o anterior", 4);
        lookupPickerFieldPeriodo.setOptionsMap(map);
        lookupPickerFieldPeriodo.setValue(2);
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
        paramsMap.put("fechaHasta", Timestamp.from(dateFieldDesde.getValue().toInstant()));
        if (lookupPickerFieldCentroDeCosto.getValue() != null) {
            paramsMap.put("centroDeCosto", lookupPickerFieldCentroDeCosto.getValue().getId().intValue());
            paramsMap.put("centroDeCostoNombre", lookupPickerFieldCentroDeCosto.getValue().getDescripcion());
        }
        if (checkBoxCtaCteDetalle.isChecked()) {
            if (lookupPickerFieldCentroDeCosto.getValue() != null) {
                generarInforme("extracto_ctacte_cc", "extracto_ctacte_subreport_saldo_anterior_cc", fileFormatEnum, paramsMap);
            } else {
                generarInforme("extracto_ctacte", "extracto_ctacte_subreport_saldo_anterior", fileFormatEnum, paramsMap);
            }
        } else {
            if (lookupPickerFieldCentroDeCosto.getValue() != null) {
                generarInforme("extracto_ctacte_resumen_cc", "extracto_ctacte_subreport_saldo_anterior_cc", fileFormatEnum, paramsMap);
            } else {
                generarInforme("extracto_ctacte_resumen", "extracto_ctacte_subreport_saldo_anterior", fileFormatEnum, paramsMap);
            }
        }

    }

    private void generarInforme(String reportFileName,
                                String subReportFileName,
                                InformesService.ReportFileFormatEnum fileFormatEnum,
                                Map paramsMap) {
        Map params = informesService.generarInforme(reportFileName,
                subReportFileName,
                fileFormatEnum,
                paramsMap
                , null);
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