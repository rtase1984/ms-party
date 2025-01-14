package com.weecover.msparty.domain.usecase;

import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;

import java.util.Optional;

public interface PartyCheckDuplicatesService<T> {
     Optional<T> checkDuplicates(FullPartyRequestDto request);
}
