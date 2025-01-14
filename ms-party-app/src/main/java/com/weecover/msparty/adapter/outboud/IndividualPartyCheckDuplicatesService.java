package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.converter.PartyNameMapper;
import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import com.weecover.msparty.adapter.inboud.rest.dto.IndividualPartyNameDto;
import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyNameDtoDto;
import com.weecover.msparty.adapter.outboud.persistence.repository.IndividualPartyNameJpaRepository;
import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import com.weecover.msparty.domain.usecase.PartyCheckDuplicatesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class IndividualPartyCheckDuplicatesService implements PartyCheckDuplicatesService<IndividualPartyDto> {
    @Autowired
    private IndividualPartyNameJpaRepository individualPartyRepository;

    @Override
    public Optional<IndividualPartyDto> checkDuplicates(FullPartyRequestDto request) {
        List<IndividualParty> duplicates = new ArrayList<>();
        /*
        for (IndividualPartyNameDtoDto name : request.partyNames()) {
            if ("with_family_names".equalsIgnoreCase(Optional.ofNullable(name.nameType()).orElse("")))  {
                duplicates = individualPartyRepository.findBySoundexName(
                        name.firstName(),
                        name.middleName(),
                        name.lastName(),
                        name.firstFamilyName(),
                        name.secondFamilyName(),
                        name.otherFamilyName()
                );
            }
        }

        return duplicates.isEmpty()
                ? Optional.empty()
                : Optional.of(PartyNameMapper.mapListPartyNamesEntity(duplicates));
                */
        return Optional.empty();
    }



}
