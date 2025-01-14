package com.weecover.msparty.adapter.outboud;

import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.ApiResponseDto;

import java.util.UUID;

public interface FullPartyService {
    ApiResponseDto<?> saveParty(FullPartyRequestDto fullPartyRequestDto);

    ApiResponseDto<?> getPartyById(UUID id);
}
