package org.mg.mgweb.entity.enums;

import com.haulmont.chile.core.datatypes.impl.EnumClass;

import javax.annotation.Nullable;


public enum FrecuenciaCobroColectasEnum implements EnumClass<Integer> {

    EVENTO(1),
    MENSUAL(2);

    private Integer id;

    FrecuenciaCobroColectasEnum(Integer value) {
        this.id = value;
    }

    public Integer getId() {
        return id;
    }

    @Nullable
    public static FrecuenciaCobroColectasEnum fromId(Integer id) {
        for (FrecuenciaCobroColectasEnum at : FrecuenciaCobroColectasEnum.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}