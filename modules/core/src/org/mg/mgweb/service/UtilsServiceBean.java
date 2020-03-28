package org.mg.mgweb.service;

import com.haulmont.cuba.core.entity.contracts.Id;
import com.haulmont.cuba.core.global.DataManager;
import org.mg.mgweb.entity.TblConfiguraciones;
import org.mg.mgweb.entity.TblEventoCuotas;
import org.mg.mgweb.entity.models.CuotaModel;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service(UtilsService.NAME)
public class UtilsServiceBean implements UtilsService {

    /**
     * Esta clase provee la funcionalidad de convertir un numero representado en
     * digitos a una representacion en letras. Mejorado para leer centavos
     *
     * @author Camilo Nova
     */
    private final String[] UNIDADES = {"", "UN ", "DOS ", "TRES ",
            "CUATRO ", "CINCO ", "SEIS ", "SIETE ", "OCHO ", "NUEVE ", "DIEZ ",
            "ONCE ", "DOCE ", "TRECE ", "CATORCE ", "QUINCE ", "DIECISEIS",
            "DIECISIETE", "DIECIOCHO", "DIECINUEVE", "VEINTE"};

    private final String[] DECENAS = {"VENTI", "TREINTA ", "CUARENTA ",
            "CINCUENTA ", "SESENTA ", "SETENTA ", "OCHENTA ", "NOVENTA ",
            "CIEN "};

    private final String[] CENTENAS = {"CIENTO ", "DOSCIENTOS ",
            "TRESCIENTOS ", "CUATROCIENTOS ", "QUINIENTOS ", "SEISCIENTOS ",
            "SETECIENTOS ", "OCHOCIENTOS ", "NOVECIENTOS "};

    public String convertNumberToLetter(String number)
            throws NumberFormatException {
        return convertNumberToLetter(Integer.valueOf(number));
    }

    /**
     * Convierte un numero en representacion numerica a uno en representacion de
     * texto. El numero es valido si esta entre 0 y 999'999.999
     *
     * @param integerNumber Numero a convertir
     * @return Numero convertido a texto
     * @throws NumberFormatException Si el numero esta fuera del rango
     */
    public String convertNumberToLetter(Integer integerNumber)
            throws NumberFormatException {
        try {
            StringBuilder converted = new StringBuilder();

            String patternThreeDecimalPoints = "#.###";

            DecimalFormat format = new DecimalFormat(patternThreeDecimalPoints);
            format.setRoundingMode(RoundingMode.DOWN);

            // formateamos el numero, para ajustarlo a el formato de tres puntos
            // decimales
            String formatedDouble = format.format(integerNumber);
            integerNumber = Integer.valueOf(formatedDouble);

            // Validamos que sea un numero legal
            if (integerNumber > 999999999) {
                throw new NumberFormatException(
                        "El numero es mayor de 999'999.999, "
                                + "no es posible convertirlo");
            }

            if (integerNumber < 0) {
                throw new NumberFormatException("El numero debe ser positivo");
            }

            String splitNumber[] = String.valueOf(integerNumber).replace('.', '#')
                    .split("#");

            // Descompone el trio de millones
            Integer millon = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    8))
                    + String.valueOf(getDigitAt(splitNumber[0], 7))
                    + String.valueOf(getDigitAt(splitNumber[0], 6)));
            if (millon == 1) {
                converted.append("UN MILLON ");
            } else if (millon > 1) {
                converted.append(convertNumber(String.valueOf(millon))
                        + "MILLONES ");
            }

            // Descompone el trio de miles
            Integer miles = Integer.parseInt(String.valueOf(getDigitAt(splitNumber[0],
                    5))
                    + String.valueOf(getDigitAt(splitNumber[0], 4))
                    + String.valueOf(getDigitAt(splitNumber[0], 3)));
            if (miles == 1) {
                converted.append("MIL ");
            } else if (miles > 1) {
                converted.append(convertNumber(String.valueOf(miles)) + "MIL ");
            }

            // Descompone el ultimo trio de unidades
            Integer cientos = Integer.parseInt(String.valueOf(getDigitAt(
                    splitNumber[0], 2))
                    + String.valueOf(getDigitAt(splitNumber[0], 1))
                    + String.valueOf(getDigitAt(splitNumber[0], 0)));
            if (cientos == 1) {
                converted.append("UN");
            }

            if (millon + miles + cientos == 0) {
                converted.append("CERO");
            }
            if (cientos > 1) {
                converted.append(convertNumber(String.valueOf(cientos)));
            }
            converted.append(" GUARANIES.");
            return converted.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Convierte los trios de numeros que componen las unidades, las decenas y
     * las centenas del numero.
     *
     * @param number Numero a convetir en digitos
     * @return Numero convertido en letras
     */
    private String convertNumber(String number) {
        try {
            if (number.length() > 3) {
                throw new NumberFormatException(
                        "La longitud maxima debe ser 3 digitos");
            }

            // Caso especial con el 100
            if (number.equals("100")) {
                return "CIEN";
            }

            StringBuilder output = new StringBuilder();
            if (getDigitAt(number, 2) != 0) {
                output.append(CENTENAS[getDigitAt(number, 2) - 1]);
            }

            Integer k = Integer.parseInt(String.valueOf(getDigitAt(number, 1))
                    + String.valueOf(getDigitAt(number, 0)));

            if (k <= 20) {
                output.append(UNIDADES[k]);
            } else if (k > 30 && getDigitAt(number, 0) != 0) {
                output.append(DECENAS[getDigitAt(number, 1) - 2] + "Y "
                        + UNIDADES[getDigitAt(number, 0)]);
            } else {
                output.append(DECENAS[getDigitAt(number, 1) - 2]
                        + UNIDADES[getDigitAt(number, 0)]);
            }

            return output.toString();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * Retorna el digito numerico en la posicion indicada de derecha a izquierda
     *
     * @param origin Cadena en la cual se busca el digito
     * @param position Posicion de derecha a izquierda a retornar
     * @return Digito ubicado en la posicion indicada
     */
    private Integer getDigitAt(String origin, Integer position) {
        if (origin.length() > position && position >= 0) {
            return origin.charAt(origin.length() - position - 1) - 48;
        }
        return 0;
    }

    private Integer Pa_Calcular_Dv_11_A(String p_numero, Integer p_basemax) {
        Integer v_total, v_resto, k, v_numero_aux, v_digit;
        String v_numero_al = "";

        for (Integer i = 0; i < p_numero.length(); i++) {
            char c = p_numero.charAt(i);
            if (Character.isDigit(c)) {
                v_numero_al += c;
            } else {
                v_numero_al += (int) c;
            }
        }

        k = 2;
        v_total = 0;

        for (Integer i = v_numero_al.length() - 1; i >= 0; i--) {
            k = k > p_basemax ? 2 : k;
            v_numero_aux = v_numero_al.charAt(i) - 48;
            v_total += v_numero_aux * k++;
        }

        v_resto = v_total % 11;
        v_digit = v_resto > 1 ? 11 - v_resto : 0;

        return v_digit;
    }

    public Boolean isValidRUC(String ruc) {
        String base = ruc.substring(0, ruc.length() - 2);
        String dv = ruc.substring(ruc.length() - 1, ruc.length());
        return String.valueOf(Pa_Calcular_Dv_11_A(base, 11)).equals(dv);
    }

    public String getRucEntero(String rucSinDv) {
        return rucSinDv + "-" + String.valueOf(Pa_Calcular_Dv_11_A(rucSinDv, 11));
    }

    public String getDVfromRUC(String ruc) {
        return ruc.substring(ruc.length() - 1, ruc.length());
    }

    public String getRUCsinDVfromRUC(String ruc) {
        return ruc.substring(0, ruc.length() - 2);
    }

    public List<CuotaModel> getCuotas(TblEventoCuotas eventoCuotas, Integer monto) {
        List<LocalDateTime> fechas = getCuotasFechas(eventoCuotas);
        List<CuotaModel> listCuotas = new ArrayList<>();
        float divi = monto * 1.0F / fechas.size();
        Integer montoCuota = Math.round(divi);
        for (LocalDateTime fecha : fechas) {
            CuotaModel cuota = new CuotaModel();
            cuota.setFecha(fecha);
            cuota.setMonto(montoCuota);
            listCuotas.add(cuota);
        }
        if (montoCuota * fechas.size() > monto) {
            CuotaModel cuota = new CuotaModel();
            cuota.setFecha(listCuotas.get(listCuotas.size() - 1).getFecha());
            cuota.setMonto(montoCuota - 1);
            listCuotas.set(listCuotas.size() - 1, cuota);
        } else if (montoCuota * fechas.size() < monto) {
            CuotaModel cuota = new CuotaModel();
            cuota.setFecha(listCuotas.get(listCuotas.size() - 1).getFecha());
            cuota.setMonto(montoCuota + 1);
            listCuotas.set(listCuotas.size() - 1, cuota);
        }

        return listCuotas;
    }

    public List<LocalDateTime> getCuotasFechas(TblEventoCuotas cuotas) {
        List<LocalDateTime> cuotasList = new ArrayList<>();
        if (cuotas.getFecha1() != null) {
            cuotasList.add(cuotas.getFecha1());
        }
        if (cuotas.getFecha2() != null) {
            cuotasList.add(cuotas.getFecha2());
        }
        if (cuotas.getFecha3() != null) {
            cuotasList.add(cuotas.getFecha3());
        }
        if (cuotas.getFecha4() != null) {
            cuotasList.add(cuotas.getFecha4());
        }
        return cuotasList;
    }

    public String getMesUpperCase(Integer mes) {
        return getMes(mes).toUpperCase();
    }

    public String getMes(Integer mes) {
        switch (mes) {
            case 1:
                return "Enero";
            case 2:
                return "Febrero";
            case 3:
                return "Marzo";
            case 4:
                return "Abril";
            case 5:
                return "Mayo";
            case 6:
                return "Junio";
            case 7:
                return "Julio";
            case 8:
                return "Agosto";
            case 9:
                return "Setiembre";
            case 10:
                return "Octubre";
            case 11:
                return "Noviembre";
            case 12:
                return "Diciembre";
            default:
                return "Error";
        }
    }

}