package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.converter.IndividualPartyNameMapper;
import com.weecover.msparty.adapter.inboud.rest.converter.PartyMapper;
import com.weecover.msparty.adapter.inboud.rest.dto.IndividualPartyNameDto;
import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.outboud.persistence.dto.IndividualPartyResponseDto;
import com.weecover.msparty.adapter.outboud.persistence.dto.PartyResponseDto;
import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import com.weecover.msparty.domain.entities.PartyHeader;
import com.weecover.msparty.domain.exception.DuplicatePartyException;
import com.weecover.msparty.domain.port.IndividualPartyNameRepository;
import com.weecover.msparty.domain.port.IndividualPartyRepository;
import com.weecover.msparty.domain.port.PartyEmailRepository;
import com.weecover.msparty.domain.port.PartyPhoneRepository;
import com.weecover.msparty.domain.usecase.PartyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class PartyServiceImpl implements PartyService {

    private final IndividualPartyRepository individualPartyRepository;
    @Autowired
    private final IndividualPartyNameRepository nameRepository;

    private final PartyEmailRepository emailRepository;
    private final PartyPhoneRepository phoneRepository;
    private final PartyMapper partyMapper;
    private final IndividualPartyNameMapper individualPartyNameMapper;

    public PartyServiceImpl(IndividualPartyRepository individualPartyRepository, IndividualPartyNameRepository nameRepository, PartyEmailRepository emailRepository, PartyPhoneRepository phoneRepository, PartyMapper partyMapper, IndividualPartyNameMapper individualPartyNameMapper) {
        this.individualPartyRepository = individualPartyRepository;
        this.nameRepository = nameRepository;
        this.emailRepository = emailRepository;
        this.phoneRepository = phoneRepository;
        this.partyMapper = partyMapper;
        this.individualPartyNameMapper = individualPartyNameMapper;
    }

    @Override
    public PartyResponseDto createIndividualParty(PartyRequestDto request) throws DuplicatePartyException {

        if (Boolean.TRUE.equals(request.duplicateCheck())) {
            List<IndividualParty> duplicates = checkForDuplicates(request);
            if (!duplicates.isEmpty()) {
                return buildDuplicateResponse(duplicates);
            }
        }

        IndividualParty savedParty = individualPartyRepository.saveIndividualParty(partyMapper.toEntity(request));

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
                        .ifPresent(firstFamilyName ->
                                duplicates.addAll(((nameRepository.findByFamilyNamesAndDeletedDateIsNull(
                                        firstFamilyName, nameDto.secondFamilyName())))));
            }

            if ("with_last_name".equalsIgnoreCase(nameDto.nameType())) {
                // Search by last name
                Optional.ofNullable(nameDto.lastName())
                        .ifPresent(lastName -> duplicates.addAll(((nameRepository.findByFamilyNamesAndDeletedDateIsNull(nameDto.firstFamilyName(), nameDto.secondFamilyName())))));
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
        List<IndividualPartyResponseDto> duplicate = partyMapper.toResponseDtoList(duplicates);


        PartyResponseDto response = new PartyResponseDto();
        response.setStatus("accepted");
        response.setMessage("Se encontraron posibles duplicados");
        response.setDuplicates(duplicate);
        return response;
    }
}
