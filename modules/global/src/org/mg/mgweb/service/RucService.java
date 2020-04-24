package org.mg.mgweb.service;

public interface RucService {
    String NAME = "mgweb_RucService";

    String getRazonSocialFromRuc(String ruc);

    Boolean isValidRUC(String ruc);

    String getRucEntero(String rucSinDv);

    String getRucEntero(Integer rucSinDv);

    String getDVfromRUC(String ruc);

    String getRUCsinDVfromRUC(String ruc);

}