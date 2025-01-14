package com.weecover.msparty.adapter.inboud.rest.converter;


import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.outboud.dto.IndividualPartyResponseDto;
import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.model.COU_ENUM;
import com.weecover.msparty.domain.model.MAS_ENUM;
import org.apache.commons.lang3.RandomStringUtils;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
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

    @AfterMapping
    default void assignRandomValues(@MappingTarget IndividualParty individualParty, PartyRequestDto dto) {
        // Genera valores aleatorios para campos que no estén presentes en la request pero sean @NotNull
        if (individualParty.getCountry() == null) {
            individualParty.setCountry(COU_ENUM.SPAIN); // Valor aleatorio
        }

        if (individualParty.getCultureCode() == null) {
            individualParty.setCultureCode(RandomStringUtils.randomAlphanumeric(12)); // Valor aleatorio
        }

        if (individualParty.getTimeZone() == null) { // Replace "Field2" with your actual field
            individualParty.setTimeZone(RandomStringUtils.randomAlphanumeric(10)); // Número aleatorio
        }

        if (individualParty.getBusinessAllowed() == null) {
            individualParty.setBusinessAllowed(false);
        }

        if (individualParty.getIsActive() == null) {
            individualParty.setIsActive(Boolean.FALSE);
        }

        if (individualParty.getDayOfBirth() == null) {
            individualParty.setDayOfBirth(Date.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }

        if (individualParty.getGender() == null) {
            individualParty.setGender("Masculino");
        }

        if (individualParty.getMaritalStatus() == null) {
            individualParty.setMaritalStatus(MAS_ENUM.MARRIED);
        }

        if (individualParty.getProfession() == null) {
            individualParty.setProfession(RandomStringUtils.randomAlphanumeric(3));
        }

        if (individualParty.getEffectiveDate() == null) {
            individualParty.setEffectiveDate(Date.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }

        if (individualParty.getExpirationDate() == null) {
            individualParty.setExpirationDate(Date.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }

        if (individualParty.getDayOfDeath() == null) {
            individualParty.setDayOfDeath(Date.from(LocalDate.of(1990, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant()));
        }

        if (individualParty.getPrefLanguage() == null) {
            individualParty.setPrefLanguage(RandomStringUtils.randomAlphabetic(12));
        }

        if (individualParty.getPrefContactType() == null) {
            individualParty.setPrefContactType(RandomStringUtils.randomAlphanumeric(3));
        }

        if (individualParty.getTypeNationalId() == null) {
            individualParty.setTypeNationalId(RandomStringUtils.randomAlphabetic(3));
        }

        if (individualParty.getNationalId() ==null) {
            individualParty.setTypeNationalId(RandomStringUtils.randomAlphabetic(20));
        }

        if (individualParty.getIsCompanyPersonnel() == null) {
            individualParty.setIsCompanyPersonnel(Boolean.FALSE);
        }

        if (individualParty.getIsActive() == null) {
            individualParty.setIsAgent(Boolean.TRUE);
        }

    }

}
