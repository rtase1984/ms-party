package com.weecover.msparty.domain.model;


import org.springframework.lang.Nullable;


public enum CON_ENUM implements EnumClass<String> {

    ADDRESS("ADR"),
    EMAIL("EMA"),
    FAX("FAX"),
    PHONE("PHO");

    private final String id;

    CON_ENUM(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static CON_ENUM fromId(String id) {
        for (CON_ENUM at : CON_ENUM.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}