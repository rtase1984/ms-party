package com.weecover.msparty.domain.model;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

@Getter
@Builder
@EqualsAndHashCode
public class MsParty {

    private final MsPartyState state;
    private final int value;
}
