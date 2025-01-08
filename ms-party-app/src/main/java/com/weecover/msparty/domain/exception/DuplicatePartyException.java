package com.weecover.msparty.domain.exception;


import com.weecover.msparty.domain.entities.PartyHeader;

import java.util.List;

public class DuplicatePartyException extends Exception {
    private final String message;
    private final List<PartyHeader> duplicateParties;

    // Constructor que recibe el mensaje y la lista de duplicados
    public DuplicatePartyException(String message, List<PartyHeader> duplicateParties) {
        super(message); // Llamamos al constructor de Exception con el mensaje
        this.message = message;
        this.duplicateParties = duplicateParties;
    }

    // Obtener el mensaje de la excepción
    @Override
    public String getMessage() {
        return message;
    }

    // Obtener la lista de partes duplicadas
    public List<PartyHeader> getDuplicateParties() {
        return duplicateParties;
    }
}
