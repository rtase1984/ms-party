package com.weecover.msparty.domain.usecase;

import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;

public interface PartyValidationService {
    void validate(FullPartyRequestDto request);
}