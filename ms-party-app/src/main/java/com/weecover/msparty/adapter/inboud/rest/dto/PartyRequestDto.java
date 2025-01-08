package com.weecover.msparty.adapter.inboud.rest.dto;

import com.weecover.msparty.domain.entities.BusinessParty;
import com.weecover.msparty.domain.entities.PartyPhone;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import java.util.Optional;

/**
 * Data Transfer Object (DTO) for capturing Party creation requests.
 * Represents the input data structure required to create a Party.
 */

public record PartyRequestDto(
        @NotBlank
        String mode,
        @NotBlank
        String partyType,
        @NotNull(message = "individualName must not be null")
        IndividualPartyNameDto individualPartyName,
        List<PartyPhoneDto> phone,
        List<PartyEmailDto>  email,
        Boolean duplicateCheck // Valor predeterminado gestionado en la lógica de negocio
) {}