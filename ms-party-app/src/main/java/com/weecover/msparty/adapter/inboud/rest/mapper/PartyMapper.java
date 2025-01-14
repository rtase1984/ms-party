package com.weecover.msparty.adapter.inboud.rest.mapper;

import com.weecover.msparty.adapter.inboud.rest.converter.PartyNameMapper;
import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.BusinessPartyDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.PartyDto;
import com.weecover.msparty.domain.entities.*;
import com.weecover.msparty.domain.model.COU_ENUM;
import com.weecover.msparty.domain.model.PTY_ENUM;


public class PartyMapper {
    public static IndividualPartyDto mapFromRequestToIndividualPartyDto(FullPartyRequestDto full){
        IndividualPartyDto individualParty = new IndividualPartyDto(
                full.externalId(),
                full.partyType(),
                full.partySubType(),
                full.country(),
                full.cultureCode(),
                full.timeZone(),
                full.businessAllowed(),
                full.isActive(),
                full.isPartyLight(),
                full.partyNames(),
                full.partyEmails(),
                full.partyPhones(),
                full.dayOfBirth(),
                full.gender(),
                full.maritalStatus(),
                full.profession(),
                full.dependants(),
                full.effectiveDate(),
                full.expirationDate(),
                full.dayOfDeath(),
                full.prefLanguage(),
                full.prefContactType(),
                full.typeNationalId(),
                full.nationalId(),
                full.isCompanyPersonnel(),
                full.isAgent(),
                full.specificPurposeId()
        );
       

        return individualParty;
    }

    public static IndividualPartyDto mapFromEntityToIndividualPartyDto(IndividualParty individual){
        IndividualPartyDto individualPartyDto = new IndividualPartyDto(
                individual.getExternalId(),
                individual.getPartyType(),
                individual.getPartySubType(),
                individual.getCountry(),
                individual.getCultureCode(),
                individual.getTimeZone(),
                individual.getBusinessAllowed(),
                individual.getIsActive(),
                individual.getIsPartyLight(),
                PartyNameMapper.mapListPartyNamesDto(individual.getPartyNames()),
                PartyEmailMapper.toDtoList(individual.getPartyEmails()),
                PartyPhoneMapper.toDtoList(individual.getPartyPhones()),
                individual.getDayOfBirth(),
                individual.getGender(),
                individual.getMaritalStatus(),
                individual.getProfession(),
                individual.getDependants(),
                individual.getEffectiveDate(),
                individual.getExpirationDate(),
                individual.getDayOfDeath(),
                individual.getPrefLanguage(),
                individual.getPrefContactType(),
                individual.getTypeNationalId(),
                individual.getNationalId(),
                individual.getIsCompanyPersonnel(),
                individual.getIsAgent(),
                individual.getSpecificPurposeId()
                );


        return individualPartyDto;
    }

    public static IndividualParty mapFromDtoToIndividualPartyEntity(IndividualPartyDto individual){
        IndividualParty individualParty = new IndividualParty();
                individualParty.setExternalId(individual.externalId());
                individualParty.setPartyType(PTY_ENUM.fromId("INDIVIDUAL"));
                individualParty.setPartySubType(individual.partySubType());
                individualParty.setCountry(COU_ENUM.fromId(String.valueOf(individual.country())));
                individualParty.setCultureCode(individual.cultureCode());
                individualParty.setTimeZone(individual.timeZone());
                individualParty.setBusinessAllowed(individual.businessAllowed());
                individualParty.setIsActive(individual.isActive());
                individualParty.setIsPartyLight(individual.isPartyLight());
                individualParty.setPartyNames(PartyNameMapper.mapListPartyNamesEntity(individual.partyNames()));
                individualParty.setPartyEmails(PartyEmailMapper.toEntityList(individual.partyEmails()));
                individualParty.setPartyPhones(PartyPhoneMapper.toEntityList(individual.partyPhones()));
                individualParty.setDayOfBirth(individual.dayOfBirth());
                individualParty.setGender(individual.gender());
                individualParty.setMaritalStatus(individual.maritalStatus());
                individualParty.setProfession(individual.profession());
                individualParty.setDependants(individual.dependants());
                individualParty.setEffectiveDate(individual.effectiveDate());
                individualParty.setExpirationDate(individual.expirationDate());
                individualParty.setDayOfDeath(individual.dayOfDeath());
                individualParty.setPrefLanguage(individual.prefLanguage());
                individualParty.setPrefContactType(individual.prefContactType());
                individualParty.setTypeNationalId(individual.typeNationalId());
                individualParty.setNationalId(individual.nationalId());
                individualParty.setIsCompanyPersonnel(individual.isCompanyPersonnel());
                individualParty.setIsAgent(individual.isAgent());
                individualParty.setSpecificPurposeId(individual.specificPurposeId());

        return individualParty;
    }


    public static IndividualPartyName mapFromRequestToIndividualPartyName(FullPartyRequestDto Full){
        IndividualPartyName individualPartyName = new IndividualPartyName();

        return individualPartyName;
    }

    public PartyDto toDTO(PartyHeader party) {
        if (party instanceof IndividualParty) {
            IndividualParty individual = (IndividualParty) party;

            return new IndividualPartyDto(
                    individual.getExternalId(),
                    individual.getPartyType(),
                    individual.getPartySubType(),
                    individual.getCountry(),
                    individual.getCultureCode(),
                    individual.getTimeZone(),
                    individual.getBusinessAllowed(),
                    individual.getIsActive(),
                    individual.getIsPartyLight(),
                    PartyNameMapper.mapListPartyNamesDto(individual.getPartyNames()),
                    PartyEmailMapper.toDtoList(individual.getPartyEmails()),
                    PartyPhoneMapper.toDtoList(individual.getPartyPhones()),
                    individual.getDayOfBirth(),
                    individual.getGender(),
                    individual.getMaritalStatus(),
                    individual.getProfession(),
                    individual.getDependants(),
                    individual.getEffectiveDate(),
                    individual.getExpirationDate(),
                    individual.getDayOfDeath(),
                    individual.getPrefLanguage(),
                    individual.getPrefContactType(),
                    individual.getTypeNationalId(),
                    individual.getNationalId(),
                    individual.getIsCompanyPersonnel(),
                    individual.getIsAgent(),
                    individual.getSpecificPurposeId()
            );
        } else if (party instanceof BusinessParty) {
            BusinessParty business = (BusinessParty) party;
            return new BusinessPartyDto(
                    business.getEfectiveDate(),
                    business.getExpirationDate(),
                    business.getBusinessType(),
                    business.getPrefLanguage(),
                    business.getPrefContactType(),
                    business.getIsAgency(),
                    business.getIsSupplier(),
                    business.getRegistrationTypeId(),
                    business.getRegistrationId()
            );
        }
        throw new IllegalArgumentException("Unknown Party type: " + party.getClass().getName());
    }
}
