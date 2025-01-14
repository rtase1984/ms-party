package com.weecover.msparty.adapter.inboud.rest.dto;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class MsPartyRequest {

    @NotNull
    @Min(1) private Integer value;
}
