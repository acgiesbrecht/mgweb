package org.mg.mgweb.service;

public interface UtilsService {
    String NAME = "mgweb_UtilsService";

    String convertNumberToLetter(Integer integerNumber);

    String convertNumberToLetter(String number);

    Boolean isValidRUC(String ruc);

    String getRucEntero(String rucSinDv);

    String getDVfromRUC(String ruc);

    String getRUCsinDVfromRUC(String ruc);

}