package com.weecover.msparty.adapter.inboud.rest.converter;

import com.weecover.msparty.adapter.inboud.rest.dto.IndividualPartyNameDto;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface IndividualPartyNameMapper {

    IndividualPartyNameMapper INSTANCE = Mappers.getMapper(IndividualPartyNameMapper.class);

    @Mapping(source = "firstName", target = "firstName")
    @Mapping(source = "middleName", target = "middleName")
    @Mapping(source = "lastName", target = "lastName")
    @Mapping(source = "firstFamilyName", target = "firstFamilyName")
    @Mapping(source = "secondFamilyName", target = "secondFamilyName")
     IndividualPartyName toEntity(IndividualPartyNameDto dto);

    @InheritInverseConfiguration
    abstract IndividualPartyNameDto toDto(IndividualPartyName entity);
}
