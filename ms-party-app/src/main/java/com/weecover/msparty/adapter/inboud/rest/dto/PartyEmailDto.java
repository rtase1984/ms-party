package com.weecover.msparty.adapter.inboud.rest.dto;

import javax.validation.constraints.Email;

public record PartyEmailDto(
        @Email(message = "Email must be a valid format (e.g., user@example.com).")
        String email
) {}