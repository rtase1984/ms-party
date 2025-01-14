package com.weecover.msparty.adapter.inboud.rest.dto.dto;
import javax.validation.constraints.Email;


import java.util.Date;

public record PartyEmailDtoDto(
        //IndividualPartyDto individualParty,
        Date effectiveDate,
        Date expirationDate, // Default a 9999-12-31
        String emailType,
        @Email(message = "Email must be a valid format (e.g., user@example.com).")
        String email,
        Boolean isPrimary,
        String comments

) {}