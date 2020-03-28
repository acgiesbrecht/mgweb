package org.mg.mgweb.entity.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum FacturaLayoutEnum implements EnumClass<String> {

    FACTURA_CON_REJILLA("factura_con_rejilla"),
    FACTURA_CON_REJILLA_CREDITO("factura_con_rejilla_credito"),
    FACTURA("factura"),
    FACTURA_CON_REJILLA_BETHEL_FULL("factura_con_rejilla_bethel_full"),
    FACTURA_CON_REJILLA_LICHTENAU("factura_con_rejilla_lichtenau");

    private String id;

    FacturaLayoutEnum(String value) {
        this.id = value;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static FacturaLayoutEnum fromId(String id) {
        for (FacturaLayoutEnum at : FacturaLayoutEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}