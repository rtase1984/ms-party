package com.weecover.msparty.adapter.inboud.rest.converter;

import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.domain.entities.IndividualParty;
import org.springframework.core.convert.converter.Converter;

public class PartyRequestDtoToIndividualPartyConverter implements Converter<PartyRequestDto, IndividualParty> {

    @Override
    public IndividualParty convert(PartyRequestDto source) {
        return null;
    }

    @Override
    public <U> Converter<PartyRequestDto, U> andThen(Converter<? super IndividualParty, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
