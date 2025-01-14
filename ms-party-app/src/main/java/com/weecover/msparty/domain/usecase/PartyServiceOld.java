package com.weecover.msparty.domain.usecase;

import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.outboud.dto.PartyFullResponseDto;
import com.weecover.msparty.adapter.outboud.dto.PartyResponseDto;
import com.weecover.msparty.domain.exception.DuplicatePartyException;

import java.util.Optional;
import java.util.UUID;

public interface PartyServiceOld {
    PartyResponseDto createIndividualParty(PartyRequestDto request) throws DuplicatePartyException;

    Optional<PartyFullResponseDto> findById(UUID id);
}
