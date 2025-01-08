package com.weecover.msparty.domain.entities;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Table(name = "INDIVIDUAL_PARTY")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class IndividualParty extends PartyHeader {

    @OneToMany(mappedBy = "individualParty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<IndividualPartyName> partyNames;

    @OneToMany(mappedBy = "individualParty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartyEmail> partyEmails;

    @OneToMany(mappedBy = "individualParty", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<PartyPhone> partyPhones;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAY_OF_BIRTH")
    private Date dayOfBirth;

    @NotNull
    @Column(name = "GENDER", length = 3)
    private String gender;

    @Column(name = "MARITAL_STATUS", length = 3)
    @NotNull
    private String maritalStatus;

    @NotNull
    @Column(name = "PROFESSION", length = 3)
    private String profession;

    @Column(name = "DEPENDANTS")
    private Integer dependants;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EFFECTIVE_DATE")
    private Date effectiveDate;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXPIRATION_DATE")
    private Date expirationDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "DAY_OF_DEATH")
    private Date dayOfDeath;

    @NotNull
    @Column(name = "PREF_LANGUAGE", length = 12)
    private String prefLanguage;

    @NotNull
    @Column(name = "PREF_CONTACT_TYPE")
    private String prefContactType;

    @NotNull
    @Column(name = "TYPE_NATIONAL_ID", length = 3)
    private String typeNationalId;

    @NotNull
    @Column(name = "NATIONAL_ID", length = 20)
    private String nationalId;

    @NotNull
    @Column(name = "IS_COMPANY_PERSONNEL")
    private Boolean isCompanyPersonnel;

    @NotNull
    @Column(name = "IS_AGENT")
    private Boolean isAgent;

    @Column(name = "SPECIFIC_PURPOSE_ID", length = 20)
    private String specificPurposeId;
}