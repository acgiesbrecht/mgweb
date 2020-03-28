package org.mg.mgweb.service;

public interface FacturacionService {
    String NAME = "mgweb_FacturacionService";

    String generateFacturaNroFull(Integer nro);

    String generateNextFacturaNroFull(String nro);

    String generateFacturaNroConEstPtoExp(String est, String ptoExp, Integer nro);

    String generateNextFacturaNroConEstPtoExp(String est, String ptoExp, String nro);

    String completarNroFactura(String nro);

    String formatFacturaNroLibroIngresos(String nro);

}