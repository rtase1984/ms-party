package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.PartyFactory;
import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import com.weecover.msparty.adapter.inboud.rest.mapper.PartyMapper;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.ApiResponseDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.PartyDto;
import com.weecover.msparty.adapter.outboud.persistence.repository.IndividualPartyJpaRepository;
import com.weecover.msparty.domain.entities.IndividualParty;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@AllArgsConstructor
public class FullPartyServiceImp implements FullPartyService {

   private IndividualPartyJpaRepository partyRepository;
   private PartyFactory partyFactory;
    private final PartyValidationDelegator partyValidationDelegator;

    @Transactional
    @Override
    public ApiResponseDto<?> saveParty(FullPartyRequestDto fullPartyRequestDto) {

        partyValidationDelegator.validate(fullPartyRequestDto);
        PartyDto party = partyFactory.createParty(fullPartyRequestDto);
        if (party instanceof IndividualPartyDto individual){
            return processIndividualParty(individual);
        }else {
            throw new IllegalArgumentException("Tipo de party no soportado.");
        }
    }

    private ApiResponseDto<?> processIndividualParty(IndividualPartyDto request) {
        // Verificar duplicados
        List<?> duplicates = new ArrayList<>();//checkForIndividualDuplicates(request.partyNames());

        if (!duplicates.isEmpty()) {
            return new ApiResponseDto<>(
                    "conflict",
                    "DUPLICATE_FOUND",
                    "Se encontraron duplicados para la solicitud.",
                    null,
                    duplicates
            );
        }

        // Mapear DTO a Entidad
        IndividualParty individualParty = PartyMapper.mapFromDtoToIndividualPartyEntity(request);

        // Persistir la entidad
        IndividualParty savedParty = partyRepository.save(individualParty);

        return new ApiResponseDto<>(
                "created",
                "SUCCESS",
                "Party individual creado exitosamente.",
                savedParty,
                null
        );
    }

    @Override
    public ApiResponseDto<?> getPartyById(UUID id) {
        try {
            // Buscar en IndividualParty
            Optional<IndividualParty> individualPartyOpt = partyRepository.findById(id);
            if (individualPartyOpt.isPresent()) {
                IndividualParty party = individualPartyOpt.get();
                return buildResponse(
                        "success",
                        "200",
                        "IndividualParty encontrado",
                        //party.getIsPartyLight() ? PartyMapper.mapFromEntityToIndividualPartyDto(party) : mapToFullDto(party),
                        PartyMapper.mapFromEntityToIndividualPartyDto(party),
                        null
                );
            }
                // Buscar en BusinessParty
                /*Optional<BusinessParty> businessPartyOpt = businessPartyRepository.findById(UUID.fromString(uuid));
                if (businessPartyOpt.isPresent()) {
                    BusinessParty party = businessPartyOpt.get();
                    return buildResponse(
                            "success",
                            "200",
                            "BusinessParty encontrado",
                            party.getIsPartyLight() ? mapToLightDto(party) : mapToFullDto(party),
                            null
                    );
                }*/
                // No encontrado
            return buildResponse("error", "404", "Party no encontrado", null, null);
        }catch (Exception ex) {
            return buildResponse("error", "500", "Error interno del servidor: " + ex.getMessage(), null, null);
        }
    }

    private ApiResponseDto<?> buildResponse(String status, String code, String message, Object data, List<?> duplicates) {
        return new ApiResponseDto<>(status, code, message, data, duplicates);
    }

}
