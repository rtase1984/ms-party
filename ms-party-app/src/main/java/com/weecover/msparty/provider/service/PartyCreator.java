package com.weecover.msparty.provider.service;

import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.domain.entities.PartyHeader;

public interface PartyCreator {
    boolean supports(String partyType, String mode);
    PartyHeader createParty(PartyRequestDto request);
}
