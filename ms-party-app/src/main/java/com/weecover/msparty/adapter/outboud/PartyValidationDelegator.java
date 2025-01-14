package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PartyValidationDelegator {
    @Autowired
    private IndividualPartyValidationService individualPartyValidationService;

    @Autowired
    private BusinessPartyValidationService businessPartyValidationService;

    public void validate(FullPartyRequestDto request) {
        switch (request.partyType()) {
            case IND -> individualPartyValidationService.validate(request);
            case BUS -> businessPartyValidationService.validate(request);
            default -> throw new IllegalArgumentException("Tipo de Party no soportado: " + request.partyType());
        }
    }
}
