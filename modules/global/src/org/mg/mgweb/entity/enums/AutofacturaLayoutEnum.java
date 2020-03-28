package org.mg.mgweb.entity.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum AutofacturaLayoutEnum implements EnumClass<String> {

    AUTOFACTURA_CON_REJILLA("autofactura_con_rejilla"),
    AUTOFACTURA("autofactura"),
    AUTOFACTURA_CON_REJILLA_BETHEL("autofactura_con_rejilla_bethel");

    private String id;

    AutofacturaLayoutEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static AutofacturaLayoutEnum fromId(String id) {
        for (AutofacturaLayoutEnum at : AutofacturaLayoutEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}