package com.weecover.msparty.adapter.inboud.rest.converter;

import com.weecover.msparty.adapter.inboud.rest.dto.MsPartyRequest;
import com.weecover.msparty.domain.model.MsParty;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import static com.weecover.msparty.domain.model.MsPartyState.NEW;

@Component
public class MsPartyRequestToMsPartyConverter implements Converter<MsPartyRequest, MsParty> {

    @Override
    public MsParty convert(final MsPartyRequest msPartyRequest) {
        return MsParty.builder().state(NEW).value(msPartyRequest.getValue()).build();
    }
}
