package com.weecover.msparty.adapter.inboud.rest.mapper;

import com.weecover.msparty.adapter.inboud.rest.dto.dto.PartyEmailDtoDto;
import com.weecover.msparty.domain.entities.PartyEmail;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PartyEmailMapper {
    // Mapea de PartyEmail a PartyEmailDto
    public static PartyEmailDtoDto toDto(PartyEmail partyEmail) {
        if (partyEmail == null) {
            return null;
        }
        return new PartyEmailDtoDto(
                //PartyMapper.mapFromEntityToIndividualPartyDto(partyEmail.getIndividualParty()),
                partyEmail.getEffectiveDate(),
                partyEmail.getExpirationDate(),
                partyEmail.getEmailType(),
                partyEmail.getEmail(),
                partyEmail.getIsPrimary(),
                partyEmail.getComments()
        );
    }

    // Mapea de PartyEmailDto a PartyEmail
    public static PartyEmail toEntity(PartyEmailDtoDto partyEmailDto) {
        if (partyEmailDto == null) {
            return null;
        }
        PartyEmail partyEmail = new PartyEmail();
        //partyEmail.setIndividualParty(PartyMapper.mapFromDtoToIndividualPartyEntity(partyEmailDto.individualParty())); // Puede requerir un mapeo adicional
        partyEmail.setEffectiveDate(partyEmailDto.effectiveDate());
        partyEmail.setExpirationDate(partyEmailDto.expirationDate());
        partyEmail.setEmailType(partyEmailDto.emailType());
        partyEmail.setEmail(partyEmailDto.email());
        partyEmail.setIsPrimary(partyEmailDto.isPrimary());
        partyEmail.setComments(partyEmailDto.comments());
        return partyEmail;
    }

    // Mapea una lista de PartyEmail a una lista de PartyEmailDto
    public static List<PartyEmailDtoDto> toDtoList(List<PartyEmail> partyEmails) {
        return partyEmails == null
                ? Collections.emptyList()
                : partyEmails.stream()
                .map(PartyEmailMapper::toDto)
                .collect(Collectors.toList());
    }

    // Mapea una lista de PartyEmailDto a una lista de PartyEmail
    public static List<PartyEmail> toEntityList(List<PartyEmailDtoDto> partyEmailDtos) {
        return partyEmailDtos == null
                ? Collections.emptyList()
                : partyEmailDtos.stream()
                .map(PartyEmailMapper::toEntity)
                .collect(Collectors.toList());
    }
}
