package com.weecover.msparty.domain.port;

import com.weecover.msparty.domain.entities.BusinessParty;
import com.weecover.msparty.domain.model.BPT_ENUM;
import com.weecover.msparty.domain.model.BusinessPartyDomain;

import java.util.List;

public interface BusinessPartyRepository  {
    List<BusinessPartyDomain> findByBusinessType(BPT_ENUM businessType);

    List<BusinessParty> findByRegistrationId(String registrationId);


}