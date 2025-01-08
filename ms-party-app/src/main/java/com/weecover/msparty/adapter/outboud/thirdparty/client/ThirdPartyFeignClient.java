package com.weecover.msparty.adapter.outboud.thirdparty.client;

import com.weecover.msparty.adapter.outboud.thirdparty.dto.CheckRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;

@FeignClient(name = "third-party", url = "${com.weecover.msparty.thirdparty.url}")
public interface ThirdPartyFeignClient {

    @PostMapping
    void check(final CheckRequest checkRequest);
}
