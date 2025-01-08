package com.weecover.msparty.adapter.inboud.rest.converter;


import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.outboud.persistence.dto.IndividualPartyResponseDto;
import com.weecover.msparty.domain.entities.IndividualParty;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {IndividualPartyNameMapper.class,
                PartyPhoneMapper.class,
                PartyEmailMapper.class},
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface PartyMapper {

    PartyMapper INSTANCE = Mappers.getMapper(PartyMapper.class);

//    @Mapping(target = "partyType", ignore = true)
    @Mapping(source = "mode", target = "isPartyLight",  qualifiedByName = "mapPartyLight")
    //@Mapping(source = "individualPartyName", target = "individualPartyName")
    //@Mapping(source = "email", target = "email")
    //@Mapping(source = "phone", target = "phone")
    IndividualParty toEntity(PartyRequestDto dto);

//    @InheritInverseConfiguration
//    PartyRequestDto toDto(IndividualParty entity);

    IndividualPartyResponseDto toResponseDto(IndividualParty entity);

    List<IndividualPartyResponseDto> toResponseDtoList(List<IndividualParty> entities);

    @Named("mapPartyLight")
    default Boolean mapPartyLight(String mode) {
        return mode.equalsIgnoreCase("light");
    }
}
