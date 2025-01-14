package com.weecover.msparty.adapter.inboud.rest;

import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import com.weecover.msparty.adapter.inboud.rest.mapper.PartyMapper;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.PartyDto;
import org.springframework.stereotype.Component;

@Component
public class PartyFactory {
    public PartyDto createParty(FullPartyRequestDto fullPartyRequestDto) {
        String type = fullPartyRequestDto.partyType().toString();
        switch (type) {
            case "IND":
                return PartyMapper.mapFromRequestToIndividualPartyDto(fullPartyRequestDto);
            case "BUS":
                return null;
            default:
                throw new IllegalArgumentException("Unknown Party type: " + fullPartyRequestDto.partyType());
        }

    }
}
