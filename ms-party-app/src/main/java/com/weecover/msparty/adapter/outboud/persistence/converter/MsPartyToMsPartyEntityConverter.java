package com.weecover.msparty.adapter.outboud.persistence.converter;

import com.weecover.msparty.adapter.outboud.persistence.dto.MsPartyEntity;
import com.weecover.msparty.domain.model.MsParty;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class MsPartyToMsPartyEntityConverter implements Converter<MsParty, MsPartyEntity> {

    @Override
    public MsPartyEntity convert(final MsParty msParty) {
        return MsPartyEntity.builder().state(msParty.getState().name())
                                        .value(msParty.getValue())
                                        .creation(LocalDateTime.now())
                                        .build();
    }
}
