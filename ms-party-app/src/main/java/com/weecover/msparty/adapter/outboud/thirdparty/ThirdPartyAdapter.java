package com.weecover.msparty.adapter.outboud.thirdparty;

import com.weecover.msparty.adapter.outboud.thirdparty.client.ThirdPartyFeignClient;
import com.weecover.msparty.adapter.outboud.thirdparty.dto.CheckRequest;
import com.weecover.msparty.domain.model.MsParty;
import com.weecover.msparty.provider.ThirdPartyProvider;
import org.springframework.stereotype.Component;

@Component
public class ThirdPartyAdapter implements ThirdPartyProvider {

    private final ThirdPartyFeignClient thirdPartyFeignClient;

    public ThirdPartyAdapter(final ThirdPartyFeignClient thirdPartyFeignClient) {
        this.thirdPartyFeignClient = thirdPartyFeignClient;
    }

    @Override
    public void evaluate(final MsParty msParty) {
        thirdPartyFeignClient.check(CheckRequest.builder().amount(msParty.getValue()).build());
    }
}
