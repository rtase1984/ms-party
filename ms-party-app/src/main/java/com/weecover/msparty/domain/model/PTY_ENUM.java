package com.weecover.msparty.domain.model;


public enum PTY_ENUM{

    INDIVIDUAL("IND"),
    BUSINESS("BUS");

    private final String id;

    PTY_ENUM(String id) {
        if (id == null || id.trim().isEmpty()) {
            throw new IllegalArgumentException("Enum ID cannot be null or empty");
        }
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public static PTY_ENUM fromId(String id) {
        for (PTY_ENUM at : PTY_ENUM.values()) {
            if (at.getId().equals(id)) {
                return at;
            }
        }
        throw new IllegalArgumentException("No matching PTY_ENUM for id: " + id);
    }
}