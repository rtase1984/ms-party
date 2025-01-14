package com.weecover.msparty.adapter.outboud;


import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyNameDtoDto;
import com.weecover.msparty.domain.usecase.PartyValidationService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IndividualPartyValidationService implements PartyValidationService {

    @Override
    public void validate(FullPartyRequestDto request) {
        validateBasicFields(request);
        validateMode(request);
        validateContactInformation(request);
        validatePartyNames(request.partyNames(), request.isPartyLight() ? "light" : "full");
    }

    private void validateBasicFields(FullPartyRequestDto request) {
        if (request.country() == null) {
            throw new IllegalArgumentException("El campo 'country' es obligatorio");
        }
        if (request.cultureCode() == null) {
            throw new IllegalArgumentException("El campo 'cultureCode' es obligatorio");
        }
    }

    private void validateMode(FullPartyRequestDto request) {
        if ("light".equalsIgnoreCase(request.isPartyLight() ? "light" : "full")) {
            if (request.dayOfBirth() == null) {
                throw new IllegalArgumentException("El campo 'dayOfBirth' es obligatorio en modo full");
            }
            if (request.gender() == null) {
                throw new IllegalArgumentException("El campo 'gender' es obligatorio en modo full");
            }
        }
    }

    private void validateContactInformation(FullPartyRequestDto request) {
        if ((request.partyEmails() == null || request.partyEmails().isEmpty()) &&
                (request.partyPhones() == null || request.partyPhones().isEmpty())) {
            throw new IllegalArgumentException("Debe proporcionar al menos un email o un teléfono");
        }
    }

    private void validatePartyNames(List<IndividualPartyNameDtoDto> partyNames, String mode) {
        if (partyNames == null || partyNames.isEmpty()) {
            throw new IllegalArgumentException("Debe especificarse al menos un 'partyName'");
        }
        for (IndividualPartyNameDtoDto name : partyNames) {
            validateIndividualPartyName(name, mode);
        }
    }

    private void validateIndividualPartyName(IndividualPartyNameDtoDto name, String mode) {
        if (name == null) {
            throw new IllegalArgumentException("El objeto 'PartyName' no puede ser nulo");
        }

        if (name.nameType() == null) {
            throw new IllegalArgumentException("El campo 'nameType' es obligatorio");
        }
        if ("WLN".equalsIgnoreCase(name.nameType())) {
            if (name.lastName() == null || name.lastName().trim().isEmpty()) {
                throw new IllegalArgumentException("El 'lastName' es obligatorio para 'nameType' WLN");
            }
        } else if ("WFN".equalsIgnoreCase(name.nameType())) {
            if (name.firstFamilyName() == null || name.firstFamilyName().trim().isEmpty()) {
                throw new IllegalArgumentException("El 'firstFamilyName' es obligatorio para 'nameType' WFN");
            }
            if (name.secondFamilyName() == null || name.secondFamilyName().trim().isEmpty()) {
                throw new IllegalArgumentException("El 'secondFamilyName' es obligatorio para 'nameType' WFN");
            }
        }

       /* if ("full".equalsIgnoreCase(mode) && (name.fullName() == null || name.fullName().trim().isEmpty())) {
            throw new IllegalArgumentException("El 'fullName' es obligatorio en modo full");
        }*/
    }
}
