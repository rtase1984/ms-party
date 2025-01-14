package com.weecover.msparty.adapter.inboud.rest.dto.dto;


import javax.validation.constraints.Pattern;

public record PartyPhoneDto(

        IndividualPartyDto individualParty,
        @Pattern(
                regexp = "^[+]?\\d{1,15}$",
                message = "Phone number must be a valid international number (e.g., +123456789)."
        )
        String phoneNumber,
        Boolean isPrimary
) {}