package org.mg.mgweb.service;

import net.sf.jasperreports.engine.JRDataSource;

import java.util.Map;

public interface InformesService {
    String NAME = "mgweb_InformesService";

    enum ReportFileFormatEnum {
        XML, XLSX, PDF, HTML, PRINT
    }

    Map<String, Object> generarInforme(String reportFileUrl,
                                        ReportFileFormatEnum fileFormat,
                                        Map paramsMap);

    Map<String, Object> generarInforme(String reportFileUrl,
                                        JRDataSource datasource,
                                        ReportFileFormatEnum fileFormat,
                                        Map paramsMap);

    /*void printInforme(String reportFileUrl,
                      Object datasource,
                      Map parameters);*/

}