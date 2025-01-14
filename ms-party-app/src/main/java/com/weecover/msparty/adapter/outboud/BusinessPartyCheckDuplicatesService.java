package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import com.weecover.msparty.domain.usecase.PartyCheckDuplicatesService;

import java.util.Optional;

public class BusinessPartyCheckDuplicatesService implements PartyCheckDuplicatesService {
    @Override
    public Optional checkDuplicates(FullPartyRequestDto request) {
        return Optional.empty();
    }
}
