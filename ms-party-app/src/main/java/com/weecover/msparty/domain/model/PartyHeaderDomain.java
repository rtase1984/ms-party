package com.weecover.msparty.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
public abstract class PartyHeaderDomain {
    private UUID partyUuid;
    private String externalId;
    private PTY_ENUM partyType;
    private String partySubType;
    private COU_ENUM country;
    private String cultureCode;
    private String timeZone;
    private Boolean businessAllowed;
    private Boolean isActive;
    private Boolean isPartyLight;
    private Integer version;

    public PartyHeaderDomain(UUID partyUuid, PTY_ENUM partyType, COU_ENUM country,
                             String cultureCode, String timeZone) {
        if (partyType == null || country == null || cultureCode == null || timeZone == null) {
            throw new IllegalArgumentException("Mandatory fields cannot be null");
        }
        this.partyUuid = partyUuid;
        this.partyType = partyType;
        this.country = country;
        this.cultureCode = cultureCode;
        this.timeZone = timeZone;
        this.businessAllowed = false;
        this.isActive = false;
        this.isPartyLight = false;
    }

    public void activateParty() {
        if (!isActive) {
            this.isActive = true;
        }
    }

    public void deactivateParty() {
        if (isActive) {
            this.isActive = false;
        }
    }
}
