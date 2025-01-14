package com.weecover.msparty.adapter.inboud.rest.dto.dto;

import lombok.*;
import java.util.*;


public record BusinessPartyDto (
        Date efectiveDate,
        Date expirationDate,
        String businessType,
        String prefLanguage,
        String prefContactType,
        Boolean isAgency,
        Boolean isSupplier,
        String registrationTypeId,
        String registrationId
) implements PartyDto {}