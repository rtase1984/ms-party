package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.converter.PartyMapper;
import com.weecover.msparty.adapter.inboud.rest.dto.IndividualPartyNameDto;
import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.outboud.persistence.dto.IndividualPartyResponseDto;
import com.weecover.msparty.adapter.outboud.persistence.dto.PartyResponseDto;
import com.weecover.msparty.adapter.outboud.persistence.repository.IndividualPartyJpaRepository;
import com.weecover.msparty.adapter.outboud.persistence.repository.IndividualPartyNameJpaRepository;
import com.weecover.msparty.adapter.outboud.persistence.repository.PartyEmailJpaRepository;
import com.weecover.msparty.adapter.outboud.persistence.repository.PartyPhoneJpaRepository;
import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import com.weecover.msparty.domain.exception.DuplicatePartyException;
import com.weecover.msparty.domain.usecase.PartyService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
@Transactional
public class PartyServiceImpl implements PartyService {

    private final IndividualPartyJpaRepository individualPartyRepository;
    private final IndividualPartyNameJpaRepository nameRepository;
    private final PartyEmailJpaRepository emailRepository;
    private final PartyPhoneJpaRepository phoneRepository;

    @Override
    public PartyResponseDto createIndividualParty(PartyRequestDto request) throws DuplicatePartyException {

        if (Boolean.TRUE.equals(request.duplicateCheck())) {
            List<IndividualParty> duplicates = checkForDuplicates(request);
            if (!duplicates.isEmpty()) {
                return buildDuplicateResponse(duplicates);
            }
        }

        IndividualParty individualParty = PartyMapper.INSTANCE.toEntity(request);

        IndividualParty savedParty = individualPartyRepository.save(individualParty);

        PartyResponseDto response = new PartyResponseDto(""," ", savedParty.getId(), null, null);
        response.setStatus("created");
        return response;
    }

    public List<IndividualParty> checkForDuplicates(PartyRequestDto request) {
        List<IndividualParty> duplicates = new ArrayList<>();
        if ("individual".equalsIgnoreCase(request.partyType()) && request.individualPartyName() != null) {
            IndividualPartyNameDto nameDto = request.individualPartyName();

            if ("with_family_names".equalsIgnoreCase(nameDto.nameType())) {
                // Search by first and second family names
                Optional.ofNullable(nameDto.firstFamilyName())
                        .ifPresent(firstFamilyName -> {
                                Optional<IndividualPartyName> partyName = nameRepository.findByFirstFamilyNameAndSecondFamilyNameAndDeletedDateIsNull(
                                        firstFamilyName, nameDto.secondFamilyName());

                                partyName.ifPresent(individualPartyName -> duplicates.add(individualPartyName.getIndividualParty()));

                                });
            }

            if ("with_last_name".equalsIgnoreCase(nameDto.nameType())) {
                // Search by last name
                Optional.ofNullable(nameDto.lastName())
                        .ifPresent(lastName -> {
                                Optional<IndividualPartyName> partyName = nameRepository.findByLastNameAndDeletedDateIsNull(lastName);

                                partyName.ifPresent(individualPartyName -> duplicates.add(individualPartyName.getIndividualParty()));

                            });
                }
        }
        return duplicates;
    }

    private void validateRequest(PartyRequestDto request) {
        if (!"light".equalsIgnoreCase(request.mode())) {
            throw new IllegalArgumentException("El modo debe ser 'light'");
        }

        if (!"individual".equalsIgnoreCase(request.partyType()) && !"business".equalsIgnoreCase(request.partyType())) {
            throw new IllegalArgumentException("El tipo de party debe ser 'individual' o 'business'");
        }

        if ("individual".equalsIgnoreCase(request.partyType()) && request.individualPartyName() == null) {
            throw new IllegalArgumentException("El nombre del individuo es obligatorio para parties de tipo 'individual'");
        }

        if (request.email() == null && request.phone() == null) {
            throw new IllegalArgumentException("Se debe proporcionar al menos un dato de contacto (email o teléfono)");
        }
    }

    private PartyResponseDto buildDuplicateResponse(List<IndividualParty> duplicates) {
        // Mapeo de duplicados a un formato legible por el cliente
        List<IndividualPartyResponseDto> duplicate = PartyMapper.INSTANCE.toResponseDtoList(duplicates);


        PartyResponseDto response = new PartyResponseDto();
        response.setStatus("accepted");
        response.setMessage("Se encontraron posibles duplicados");
        response.setDuplicates(duplicate);
        return response;
    }
}
