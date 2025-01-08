package com.weecover.msparty.domain.entities;

//import com.weecover.msparty.domain.model.COU_ENUM;
//import com.weecover.msparty.domain.model.PTY_ENUM;
//import com.weecover.msparty.domain.model.COU_ENUM;
//import com.weecover.msparty.domain.model.PTY_ENUM;
import com.weecover.msparty.domain.model.COU_ENUM;
import com.weecover.msparty.domain.model.PTY_ENUM;
import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class PartyHeader extends BaseAuditEntity{

    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartyName> partyNames;

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
