package com.weecover.msparty.domain.model;

import org.springframework.lang.Nullable;


public enum COU_ENUM{

    ANDORRA("AD"),
    UNITED_ARAB_EMIRATES("AE"),
    AFGHANISTAN("AF"),
    SPAIN("SP");

    private final String id;

    COU_ENUM(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static COU_ENUM fromId(String id) {
        for (COU_ENUM at : COU_ENUM.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}