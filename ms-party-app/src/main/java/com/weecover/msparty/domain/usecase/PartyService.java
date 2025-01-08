package com.weecover.msparty.domain.usecase;

import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.outboud.persistence.dto.PartyResponseDto;
import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import com.weecover.msparty.domain.entities.PartyEmail;
import com.weecover.msparty.domain.entities.PartyPhone;
import com.weecover.msparty.domain.exception.DuplicatePartyException;

import java.util.List;
import java.util.UUID;

public interface PartyService {
    PartyResponseDto createIndividualParty(PartyRequestDto request) throws DuplicatePartyException;
}
