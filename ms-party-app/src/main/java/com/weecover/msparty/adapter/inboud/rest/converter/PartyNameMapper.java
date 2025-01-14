package com.weecover.msparty.adapter.inboud.rest.converter;


import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyNameDtoDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.PartyNameDto;
import com.weecover.msparty.domain.entities.IndividualPartyName;

import com.weecover.msparty.domain.entities.PartyName;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;


public class PartyNameMapper {
    public static IndividualPartyNameDtoDto toDto(PartyName partyName) {
        if (partyName instanceof IndividualPartyName) {
            IndividualPartyName individualName = (IndividualPartyName) partyName;

            return new IndividualPartyNameDtoDto(
                    individualName.getNameType(),
                    individualName.getNamePrefix(),
                    individualName.getFirstName(),
                    individualName.getNameSufix(),
                    individualName.getPhoneticFirstName(),
                    individualName.getSoundexFirstName(),
                    individualName.getMiddleName(),
                    individualName.getPhoneticMiddleName(),
                    individualName.getSoundexMiddleName(),
                    individualName.getLastName(),
                    individualName.getPhoneticLastName(),
                    individualName.getSoundexLastName(),
                    individualName.getFirstFamilyName(),
                    individualName.getPhoneticFirstFamilyName(),
                    individualName.getSoundexFirstFamilyName(),
                    individualName.getSecondFamilyName(),
                    individualName.getPhoneticSecondFamilyName(),
                    individualName.getSoundexSecondFamilyName(),
                    individualName.getOtherFamilyName(),
                    individualName.getPhoneticOtherFamilyName(),
                    individualName.getSoundexOtherFamilyName(),
                    individualName.getFullName(),
                    individualName.getComments());

        } else return null;

    }

    public static IndividualPartyName toIndividualNameEntity(PartyNameDto partyNameDto) {
        if (partyNameDto == null) {
            return null;
        }
        if (partyNameDto instanceof IndividualPartyNameDtoDto) {
            IndividualPartyNameDtoDto individualNameDto = (IndividualPartyNameDtoDto) partyNameDto;
            IndividualPartyName individualName = new IndividualPartyName();
                    individualName.setNameType(individualNameDto.nameType());
                    individualName.setNamePrefix(individualNameDto.namePrefix());
                    individualName.setFirstName(individualNameDto.firstName());
                    individualName.setNameSufix(individualNameDto.nameSufix());
                    individualName.setPhoneticFirstName(individualNameDto.phoneticFirstName());
                    individualName.setSoundexFirstName(individualNameDto.soundexFirstName());
                    individualName.setMiddleName(individualNameDto.middleName());
                    individualName.setPhoneticMiddleName(individualNameDto.phoneticMiddleName());
                    individualName.setSoundexMiddleName(individualNameDto.soundexMiddleName());
                    individualName.setLastName(individualNameDto.lastName());
                    individualName.setPhoneticLastName(individualNameDto.phoneticLastName());
                    individualName.setSoundexLastName(individualNameDto.soundexLastName());
                    individualName.setFirstFamilyName(individualNameDto.firstFamilyName());
                    individualName.setPhoneticFirstFamilyName(individualNameDto.phoneticFirstFamilyName());
                    individualName.setSoundexFirstFamilyName(individualNameDto.soundexFirstFamilyName());
                    individualName.setSecondFamilyName(individualNameDto.secondFamilyName());
                    individualName.setPhoneticSecondFamilyName(individualNameDto.phoneticSecondFamilyName());
                    individualName.setSoundexSecondFamilyName(individualNameDto.soundexSecondFamilyName());
                    individualName.setOtherFamilyName(individualNameDto.otherFamilyName());
                    individualName.setPhoneticOtherFamilyName(individualName.getPhoneticOtherFamilyName());
                    individualName.setSoundexOtherFamilyName(individualNameDto.soundexOtherFamilyName());

                    individualName.setFullName(individualNameDto.firstName());
                    individualName.setComments(individualNameDto.comments());
          
            
            return individualName;
        } else return null;
        
    }

    public static List<IndividualPartyNameDtoDto> mapListPartyNamesDto(List<IndividualPartyName> partyNames) {
        return partyNames == null
                ? Collections.emptyList()
                : partyNames.stream()
                .map(individualPartyName -> (IndividualPartyName) individualPartyName) // Cast explícito
                .map(PartyNameMapper::toDto) // Reutilizar PartyNameMapper::toDto
                .map(dto -> (IndividualPartyNameDtoDto) dto) // Cast al DTO específico
                .collect(Collectors.toList());
    }

    public static List<IndividualPartyName> mapListPartyNamesEntity(List<IndividualPartyNameDtoDto> partyNames) {
        return partyNames == null
                ? Collections.emptyList()
                : partyNames.stream()
                .map(individualPartyNameDtoDto -> (IndividualPartyNameDtoDto) individualPartyNameDtoDto) // Cast explícito
                .map(PartyNameMapper::toIndividualNameEntity) // Reutilizar PartyNameMapper::toDto
                .map(dto -> (IndividualPartyName) dto) // Cast al DTO específico
                .collect(Collectors.toList());
    }

}
