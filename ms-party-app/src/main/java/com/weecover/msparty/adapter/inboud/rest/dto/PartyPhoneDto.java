package com.weecover.msparty.adapter.inboud.rest.dto;

import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyDto;
import lombok.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyPhoneDto {

    private IndividualPartyDto individualParty;
    private String phoneNumber;
    private Boolean isPrimary;

}