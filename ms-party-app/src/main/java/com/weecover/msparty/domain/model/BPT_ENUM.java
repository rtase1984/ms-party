package com.weecover.msparty.domain.model;

import org.springframework.lang.Nullable;


public enum BPT_ENUM implements EnumClass<String> {

    ACT("Accounting"),
    AGR("Agriculture"),
    ARC("Architect"),
    COM("Communications"),
    CON("Consulting"),
    OTH("Others");

    private final String id;

    BPT_ENUM(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Nullable
    public static BPT_ENUM fromId(String id) {
        for (BPT_ENUM at : BPT_ENUM.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        return null;
    }
}