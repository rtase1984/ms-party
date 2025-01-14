package com.weecover.msparty.adapter.inboud.rest.dto;

import com.weecover.msparty.adapter.inboud.rest.dto.dto.IndividualPartyDto;
import lombok.*;
import java.util.*;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PartyEmailDto {

    private IndividualPartyDto individualParty;
    private Date effectiveDate;
    private Date expirationDate;
    private String emailType;
    private String email;
    private Boolean isPrimary;
    private String comments;

}