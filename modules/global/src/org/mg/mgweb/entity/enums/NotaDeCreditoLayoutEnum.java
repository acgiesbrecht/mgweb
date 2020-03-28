package org.mg.mgweb.entity.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum NotaDeCreditoLayoutEnum implements EnumClass<String> {

    NOTA_DE_CREDITO_CON_REJILLA("nota_de_credito_con_rejilla"),
    NOTA_DE_CREDITO("nota_de_credito"),
    NOTA_DE_CREDITO_CON_REJILLA_BETHEL("nota_de_credito_con_rejilla_bethel");

    private String id;

    NotaDeCreditoLayoutEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static NotaDeCreditoLayoutEnum fromId(String id) {
        for (NotaDeCreditoLayoutEnum at : NotaDeCreditoLayoutEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}