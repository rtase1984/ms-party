package com.weecover.msparty.adapter.inboud.rest.dto;

import javax.validation.constraints.Pattern;

public record PartyPhoneDto(
        @Pattern(
                regexp = "^[+]?\\d{1,15}$",
                message = "Phone number must be a valid international number (e.g., +123456789)."
        )
        String phoneNumber
) {}