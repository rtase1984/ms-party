package com.weecover.msparty.adapter.inboud.rest.dto.dto;

import java.util.List;

public record ApiResponseDto<T>(
        String status,
        String code,
        String message,        // Descripción del estado
        T data,                // Elemento creado (IndividualParty o BusinessParty)
        List<?> duplicates     // Lista de duplicados encontrados (si los hay)
) {
}
