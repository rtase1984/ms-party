package com.weecover.msparty.adapter.inboud.rest.converter;

import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.domain.entities.PartyEmail;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapping;

public interface PartyEmailMapper {


    @Mapping(source = "email", target = "email")
    PartyEmail toEntity(PartyRequestDto dto);

    //PartyRequestDto toDto(PartyEmail entity);
}
