package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyNameDtoDto;
import com.weecover.msparty.domain.usecase.PartyValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusinessPartyValidationService implements PartyValidationService {
    @Override
    public void validate(FullPartyRequestDto request) {
        validateBasicFields(request);
        validatePartyNames(request.partyNames(), request.isPartyLight() ? "light" : "full");
        // Validaciones adicionales para BusinessParty
    }

    private void validateBasicFields(FullPartyRequestDto request) {
        if (request.externalId() == null) {
            throw new IllegalArgumentException("El campo 'externalId' es obligatorio para BusinessParty");
        }
    }

    private void validatePartyNames(List<IndividualPartyNameDtoDto> partyNames, String mode) {
        if (partyNames == null || partyNames.isEmpty()) {
            throw new IllegalArgumentException("Debe especificarse al menos un 'partyName'");
        }
        for (IndividualPartyNameDtoDto name : partyNames) {
            validateBusinessPartyName(name, mode);
        }
    }

    private void validateBusinessPartyName(IndividualPartyNameDtoDto name, String mode) {
        // Validación para nombres de BusinessParty
    }
}
