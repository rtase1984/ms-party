package com.weecover.msparty.adapter.inboud.rest.dto;

import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
public class MsPartyRequest {

    @NotNull @Min(1) private Integer value;
}
