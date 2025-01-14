package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.converter.PartyMapper;
import com.weecover.msparty.adapter.inboud.rest.dto.IndividualPartyNameDto;
import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.outboud.dto.IndividualPartyResponseDto;
import com.weecover.msparty.adapter.outboud.dto.PartyFullResponseDto;
import com.weecover.msparty.adapter.outboud.dto.PartyResponseDto;
import com.weecover.msparty.adapter.outboud.persistence.repository.IndividualPartyJpaRepository;
import com.weecover.msparty.adapter.outboud.persistence.repository.IndividualPartyNameJpaRepository;
import com.weecover.msparty.adapter.outboud.persistence.repository.PartyEmailJpaRepository;
import com.weecover.msparty.adapter.outboud.persistence.repository.PartyPhoneJpaRepository;
import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import com.weecover.msparty.domain.usecase.PartyServiceOld;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
@Transactional
public class PartyServiceOldImpl implements PartyServiceOld {

    private final IndividualPartyJpaRepository individualPartyRepository;
    private final IndividualPartyNameJpaRepository nameRepository;
    private final PartyEmailJpaRepository emailRepository;
    private final PartyPhoneJpaRepository phoneRepository;
    private final PartyValidationDelegator partyValidationDelegator;

    @Override
    public PartyResponseDto createIndividualParty(PartyRequestDto request) {
        PartyResponseDto response = new PartyResponseDto();
        try {
            if (Boolean.TRUE.equals(request.duplicateCheck())) {
                List<IndividualParty> duplicates = checkForDuplicates(request);
                if (!duplicates.isEmpty()) {
                    return buildDuplicateResponse(duplicates);
                }
            }

            IndividualParty individualParty = PartyMapper.INSTANCE.toEntity(request);

            IndividualParty savedParty = individualPartyRepository.save(individualParty);

            // Construir respuesta exitosa
            response.setStatus("created");
            response.setMessage("Party creado correctamente");
            response.setId(savedParty.getId());
        } catch (IllegalArgumentException e) {
            // Construir respuesta de error de validación
            response.setStatus("error");
            response.setMessage("Errores en la validación de la solicitud");
            response.setErrors(List.of(new PartyResponseDto.ValidationError("request", e.getMessage())));
        } catch (Exception e) {
            // Construir respuesta de error genérico
            response.setStatus("error");
            response.setMessage("Error inesperado: " + e.getMessage());
        }

        return response;
    }

    @Override
    public Optional<PartyFullResponseDto> findById(UUID id) {
        return Optional.empty();
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
