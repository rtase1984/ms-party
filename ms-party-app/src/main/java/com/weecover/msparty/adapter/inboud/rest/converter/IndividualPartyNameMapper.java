package com.weecover.msparty.adapter.inboud.rest.converter;

import com.weecover.msparty.adapter.inboud.rest.dto.IndividualPartyNameDto;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import org.apache.commons.lang3.RandomStringUtils;
import org.mapstruct.*;
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


    @AfterMapping
    default void assignRandomValues(@MappingTarget IndividualPartyName individualPartyName, IndividualPartyNameDto dto) {
        // Genera valores aleatorios para campos que no estén presentes en la request pero sean @NotNull
        if (individualPartyName.getCountry() == null) {
            individualPartyName.setCountry(RandomStringUtils.randomAlphabetic(3)); // Valor aleatorio
        }
    }
}


