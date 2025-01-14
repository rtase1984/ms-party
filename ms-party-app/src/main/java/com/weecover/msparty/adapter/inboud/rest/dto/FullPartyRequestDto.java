package com.weecover.msparty.adapter.inboud.rest.dto;

import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyNameDtoDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.PartyEmailDtoDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.PartyPhoneDtoDto;
import com.weecover.msparty.domain.model.COU_ENUM;
import com.weecover.msparty.domain.model.MAS_ENUM;
import com.weecover.msparty.domain.model.PTY_ENUM;

import java.util.Date;
import java.util.List;

public record FullPartyRequestDto(
        String externalId,
        PTY_ENUM partyType,
        String partySubType,
        COU_ENUM country,
        String cultureCode,
        String timeZone,
        Boolean businessAllowed,
        Boolean isActive,
        Boolean isPartyLight,
        List<IndividualPartyNameDtoDto> partyNames,
        List<PartyEmailDtoDto> partyEmails,
        List<PartyPhoneDtoDto> partyPhones,
        Date dayOfBirth,
        String gender,
        MAS_ENUM maritalStatus,
        String profession,
        Integer dependants,
        Date effectiveDate,
        Date expirationDate,
        Date dayOfDeath,
        String prefLanguage,
        String prefContactType,
        String typeNationalId,
        String nationalId,
        Boolean isCompanyPersonnel,
        Boolean isAgent,
        String specificPurposeId
) {
}
