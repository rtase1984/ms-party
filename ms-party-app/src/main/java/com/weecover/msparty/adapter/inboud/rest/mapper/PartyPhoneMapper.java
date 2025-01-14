package com.weecover.msparty.adapter.inboud.rest.mapper;


import com.weecover.msparty.adapter.inboud.rest.dto.dto.PartyPhoneDtoDto;
import com.weecover.msparty.domain.entities.PartyPhone;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class PartyPhoneMapper {
    public static PartyPhoneDtoDto toDto(PartyPhone partyPhone) {
        if (partyPhone == null) {
            return null;
        }
        return new PartyPhoneDtoDto(
                //PartyMapper.mapFromEntityToIndividualPartyDto(partyPhone.getIndividualParty()),
                partyPhone.getPhoneNumber(),
                partyPhone.getIsPrimary()
        );
    }

    // Mapea de PartyPhoneDto a PartyPhone
    public static PartyPhone toEntity(PartyPhoneDtoDto partyPhoneDto) {
        if (partyPhoneDto == null) {
            return null;
        }
        PartyPhone partyPhone = new PartyPhone();
        //partyPhone.setIndividualParty(PartyMapper.mapFromDtoToIndividualPartyEntity(partyPhoneDto.individualParty())); // Puede requerir un mapeo adicional
        partyPhone.setPhoneNumber(partyPhoneDto.phoneNumber());
        partyPhone.setIsPrimary(partyPhoneDto.isPrimary());
        return partyPhone;
    }

    // Mapea una lista de PartyPhone a una lista de PartyPhoneDtoDto
    public static List<PartyPhoneDtoDto> toDtoList(List<PartyPhone> partyPhones) {
        return partyPhones == null
                ? Collections.emptyList()
                : partyPhones.stream()
                .map(PartyPhoneMapper::toDto)
                .collect(Collectors.toList());
    }

    // Mapea una lista de PartyPhoneDtoDto a una lista de PartyPhone
    public static List<PartyPhone> toEntityList(List<PartyPhoneDtoDto> partyPhoneDtos) {
        return partyPhoneDtos == null
                ? Collections.emptyList()
                : partyPhoneDtos.stream()
                .map(PartyPhoneMapper::toEntity)
                .collect(Collectors.toList());
    }
}
