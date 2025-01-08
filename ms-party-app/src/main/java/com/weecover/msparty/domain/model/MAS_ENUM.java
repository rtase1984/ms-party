package com.weecover.msparty.domain.model;

import org.springframework.lang.Nullable;


public enum MAS_ENUM {

    DIVORCED("DIV"),
    MARRIED("MAR");

    private final String id;

    MAS_ENUM(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static MAS_ENUM fromId(String id) {
        for (MAS_ENUM at : MAS_ENUM.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}