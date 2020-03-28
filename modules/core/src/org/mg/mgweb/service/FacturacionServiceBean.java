package org.mg.mgweb.service;

import org.springframework.stereotype.Service;

@Service(FacturacionService.NAME)
public class FacturacionServiceBean implements FacturacionService {

    public String generateFacturaNroFull(Integer nro) {
        try {
            return String.format("001-001-%07d", nro);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String generateNextFacturaNroFull(String nro) {
        try {
            String[] s = nro.split("-");
            Integer i = Integer.parseInt(s[2]) + 1;
            return String.format(s[0] + "-" + s[1] + "-%07d", i);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String generateFacturaNroConEstPtoExp(String est, String ptoExp, Integer nro) {
        try {
            return est + "-" + ptoExp + "-" + String.format("%07d", nro);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String generateNextFacturaNroConEstPtoExp(String est, String ptoExp, String nro) {
        try {
            String[] s = nro.split("-");
            Integer i = Integer.parseInt(s[2]) + 1;
            return String.format(est + "-" + ptoExp + "-%07d", i);
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String completarNroFactura(String nro) {
        try {
            String temp = nro.replace("_", "");
            String[] partes = temp.split("-");
            if (partes.length > 0) {
                return partes[0] + "-" + partes[1] + "-" + String.format("%07d", Integer.parseInt(partes[2]));
            } else {
                return nro;
            }
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    public String formatFacturaNroLibroIngresos(String nro) {
        if (!nro.contains("-")) {
            return generateFacturaNroFull(Integer.parseInt(nro.trim()));
        } else {
            return nro;
        }
    }

}