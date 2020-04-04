package org.mg.mgweb.service;

import com.haulmont.cuba.core.Persistence;
import com.haulmont.cuba.core.global.Resources;
import com.haulmont.cuba.core.sys.AppContext;
import net.sf.jasperreports.engine.*;
import net.sf.jasperreports.engine.export.HtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRPrintServiceExporter;
import net.sf.jasperreports.engine.export.JRXmlExporter;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.*;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;
import javax.print.DocFlavor;
import javax.print.StreamPrintService;
import javax.print.StreamPrintServiceFactory;
import java.io.ByteArrayOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import static org.mg.mgweb.service.InformesService.ReportFileFormatEnum.PRINT;

@Service(InformesService.NAME)
public class InformesServiceBean implements InformesService {

    @Inject
    protected Resources resources;
    @Inject
    protected PrintService printService;
    @Inject
    protected Persistence persistence;

    @Transactional
    public Map<String, Object> generarInforme(String reportFileUrl,
                                              ReportFileFormatEnum fileFormat,
                                              Map parameters) {
        try {
            return generarInforme(reportFileUrl, null, fileFormat, parameters);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    @Transactional
    public Map<String, Object> generarInforme(String reportFileUrl,
                                              JRDataSource datasource,
                                              ReportFileFormatEnum fileFormat,
                                              Map parameters) {
        try {
            java.util.Locale locale = new Locale("es", "PY");
            parameters.put(JRParameter.REPORT_LOCALE, locale);

            //parameters.put("logo_cch", ImageIO.read(resources.getResourceAsStream("com/chortitzer/cinweb/reports/images/logo_cch.png")));

            JasperReport report = JasperCompileManager.compileReport(resources.getResourceAsStream(reportFileUrl));

            JasperPrint jasperPrint;
            if (datasource == null) {
                try (Connection connection = getConnection()) {
                    jasperPrint = JasperFillManager.fillReport(report, parameters, connection);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            } else {
                jasperPrint = JasperFillManager.fillReport(report, parameters, datasource);
            }
            return exportReport(fileFormat, jasperPrint, parameters.get("reportScreenCaption").toString());
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /*@Transactional
    public void printInforme(String reportFileUrl,
                             Object datasource,
                             Map parameters) {

        printService.print(new ByteArrayInputStream((byte[]) generateInforme(reportFileUrl, datasource, PRINT, parameters)
                .get("reportParam")));
    }*/

    private Map<String, Object> exportReport(ReportFileFormatEnum fileFormat, JasperPrint jasperPrint, String screenCaption) {
        try {
            Map<String, Object> paramsMap = new HashMap<>();
            paramsMap.put("reportScreenCaption", screenCaption);

            final Exporter exporter;
            final ByteArrayOutputStream out = new ByteArrayOutputStream();
            boolean html = false;

            switch (fileFormat) {
                case HTML:
                    exporter = new HtmlExporter();
                    exporter.setExporterOutput(new SimpleHtmlExporterOutput(out));
                    html = true;
                    paramsMap.put("mimeType", "text/html");
                    paramsMap.put("fileName", screenCaption + ".html");
                    break;
                case XML:
                    exporter = new JRXmlExporter();
                    paramsMap.put("mimeType", "application/xml");
                    paramsMap.put("fileName", screenCaption + ".xml");
                    break;
                case XLSX:
                    exporter = new JRXlsxExporter();
                    paramsMap.put("mimeType", "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
                    paramsMap.put("fileName", screenCaption + ".xlsx");
                    break;
                case PDF:
                    exporter = new JRPdfExporter();
                    paramsMap.put("mimeType", "application/pdf");
                    paramsMap.put("fileName", screenCaption + ".pdf");
                    break;
                case PRINT:
                    exporter = new JRPrintServiceExporter();
                    exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                    SimplePrintServiceExporterConfiguration configuration = new SimplePrintServiceExporterConfiguration();
                    configuration.setDisplayPageDialog(false);
                    StreamPrintServiceFactory[] factories = StreamPrintServiceFactory.lookupStreamPrintServiceFactories(
                            DocFlavor.SERVICE_FORMATTED.PRINTABLE,
                            DocFlavor.BYTE_ARRAY.POSTSCRIPT.getMimeType());
                    try {
                        StreamPrintService printService = factories[0].getPrintService(out);
                        configuration.setPrintService(printService);
                        exporter.setConfiguration(configuration);
                        exporter.exportReport();
                    } catch (Exception ex) {
                        throw new RuntimeException(ex);
                    }
                    break;
                default:
                    throw new JRException("Unknown report format: " + fileFormat.toString());
            }

            if (!html) {
                exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(out));
            }
            if (fileFormat != PRINT) {
                exporter.setExporterInput(new SimpleExporterInput(jasperPrint));
                exporter.exportReport();
            }
            paramsMap.put("reportParam", out.toByteArray());
            return paramsMap;
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:postgresql://"
                            + AppContext.getProperty("cuba.dataSource.host")
                            + ":" + AppContext.getProperty("cuba.dataSource.port") + "/"
                            + AppContext.getProperty("cuba.dataSource.dbName"),
                    AppContext.getProperty("cuba.dataSource.username"),
                    AppContext.getProperty("cuba.dataSource.password")
            );
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}