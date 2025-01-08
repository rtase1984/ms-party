package com.weecover.msparty.domain.model;

import org.springframework.lang.Nullable;


public enum REG_ENUM implements EnumClass<String> {

    NIF("Tax Identification Number");

    private final String id;

    REG_ENUM(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static REG_ENUM fromId(String id) {
        for (REG_ENUM at : REG_ENUM.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}