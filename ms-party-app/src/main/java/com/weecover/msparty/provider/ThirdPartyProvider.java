package com.weecover.msparty.provider;

import com.weecover.msparty.domain.model.MsParty;

public interface ThirdPartyProvider {

    void evaluate(final MsParty msParty);
}
