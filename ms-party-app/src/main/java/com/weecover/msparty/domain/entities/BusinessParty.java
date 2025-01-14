package com.weecover.msparty.domain.entities;

import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import java.util.Date;

@Entity
@Getter
@Setter
public class BusinessParty extends PartyHeader {
    @NotNull
    @Temporal(TemporalType.DATE)
    @Column(name = "EFECTIVE_DATE")
    private Date efectiveDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    @Column(name = "BUSINESS_TYPE")
    private String businessType;

    @Column(name = "PREF_LANGUAGE", length = 12)
    private String prefLanguage;

    @Column(name = "PREF_CONTACT_TYPE")
    private String prefContactType;

    @NotNull
    @Column(name = "IS_AGENCY")
    private Boolean isAgency;

    @NotNull
    @Column(name = "IS_SUPPLIER")
    private Boolean isSupplier;

    @NotNull
    @Column(name = "REGISTRATION_TYPE_ID", length = 3)
    private String registrationTypeId;

    @NotNull
    @Column(name = "REGISTRATION_ID", length = 20)
    private String registrationId;


}