package com.weecover.msparty.adapter.inboud.rest.converter;

import com.weecover.msparty.adapter.inboud.rest.dto.dto.PartyPhoneDto;
import com.weecover.msparty.domain.entities.PartyPhone;
import org.mapstruct.Mapping;

public interface PartyPhoneMapper {

    @Mapping(source = "phoneNumber", target = "phoneNumber")
    PartyPhone toEntity(PartyPhoneDto dto);
}
