package org.mg.mgweb.service;

import net.sf.jasperreports.engine.JRDataSource;

import java.util.Map;

public interface InformesService {
    String NAME = "mgweb_InformesService";

    enum ReportFileFormatEnum {
        XML, XLSX, PDF, HTML, PRINT
    }

    Map<String, Object> generarInforme(String reportFileName,
                                       String subReportFileName,
                                       String subSubReportFileName,
                                       ReportFileFormatEnum fileFormat,
                                       Map paramsMap,
                                       JRDataSource datasource,
                                       Boolean landscape);

    Map<String, Object> generarInforme(String reportFileName,
                                       String subReportFileName,
                                       ReportFileFormatEnum fileFormat,
                                       Map paramsMap,
                                       JRDataSource datasource,
                                       Boolean landscape);

    Map<String, Object> generarInforme(String reportFileName,
                                        ReportFileFormatEnum fileFormat,
                                        Map paramsMap,
                                       JRDataSource datasource,
                                       Boolean landscape);

    /*void printInforme(String reportFileUrl,
                      Object datasource,
                      Map parameters);*/

}