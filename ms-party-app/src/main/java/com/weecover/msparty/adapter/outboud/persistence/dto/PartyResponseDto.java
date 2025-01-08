package com.weecover.msparty.adapter.outboud.persistence.dto;

import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.model.PartyHeaderDomain;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;
import java.util.UUID;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PartyResponseDto {
    private String status; // Valores posibles: "created", "accepted", "error"
    private String message; // Mensaje descriptivo (e.g., "Party creado correctamente", "Se encontraron duplicados", etc.)
    private UUID id; // Solo se devuelve si el estado es "created".
    private List<IndividualPartyResponseDto> duplicates; // Lista de partidos duplicados encontrados (solo si status = "accepted").
    private List<ValidationError> errors; // Detalle de errores de validación (solo si status = "error").


    @Getter
    @Setter
    public static class ValidationError {

        private String field; // Campo que tiene el error (e.g., "party_type", "email").

        private String error; // Descripción del error (e.g., "El campo es obligatorio").

        public ValidationError() {
        }

        public ValidationError(String field, String error) {
            this.field = field;
            this.error = error;
        }

    }
}
