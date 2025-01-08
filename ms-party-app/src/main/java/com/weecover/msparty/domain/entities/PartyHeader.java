package com.weecover.msparty.domain.entities;

import com.weecover.msparty.domain.model.COU_ENUM;
import com.weecover.msparty.domain.model.PTY_ENUM;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class PartyHeader extends BaseAuditEntity{

    @Column(name = "EXTERNAL_ID")
    private String externalId;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "PARTY_TYPE", nullable = false, length = 3)
    private PTY_ENUM partyType;

    @Column(name = "PARTY_SUB_TYPE", length = 3)
    private String partySubType;

    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(name = "COUNTRY", nullable = false, length = 3)
    private COU_ENUM country;

    @Column(name = "CULTURE_CODE", nullable = false, length = 12)
    @NotNull
    private String cultureCode;

    @Column(name = "TIME_ZONE", nullable = false)
    @NotNull
    private String timeZone;

    @Column(name = "BUSINESS_ALLOWED", nullable = false)
    @NotNull
    private Boolean businessAllowed = false;

    @Column(name = "IS_ACTIVE", nullable = false)
    @NotNull
    private Boolean isActive = false;

    @Column(name = "IS_PARTY_LIGHT", nullable = false)
    @NotNull
    private Boolean isPartyLight = false;
}
