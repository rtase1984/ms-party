package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class PartyCheckDuplicatesDelegator {
    @Autowired
    private IndividualPartyCheckDuplicatesService individualPartyCheckDuplicatesService;

    @Autowired
    private BusinessPartyCheckDuplicatesService businessPartyCheckDuplicatesService;

    public Optional<?> checkDuplicates(FullPartyRequestDto request) {
        return switch (request.partyType()) {
            case IND -> individualPartyCheckDuplicatesService.checkDuplicates(request);
            case BUS -> businessPartyCheckDuplicatesService.checkDuplicates(request);
            default -> throw new IllegalArgumentException("Tipo de Party no soportado: " + request.partyType());
        };
    }
}
