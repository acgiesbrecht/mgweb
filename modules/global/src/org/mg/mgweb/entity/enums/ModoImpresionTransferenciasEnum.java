package org.mg.mgweb.entity.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum ModoImpresionTransferenciasEnum implements EnumClass<Integer> {

    NORMAL(1),
    TRIPLICADO(2);

    private Integer id;

    ModoImpresionTransferenciasEnum(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static ModoImpresionTransferenciasEnum fromId(Integer id) {
        for (ModoImpresionTransferenciasEnum at : ModoImpresionTransferenciasEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}