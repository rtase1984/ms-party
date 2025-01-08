package com.weecover.msparty.domain.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Getter
@Setter
public class IndividualPartyDomain extends PartyHeaderDomain{
    private Date dayOfBirth;
    private String gender;
    private String maritalStatus;
    private String profession;
    private Integer dependants;
    private Date effectiveDate;
    private Date expirationDate;
    private Date dayOfDeath;
    private String prefLanguage;
    private String prefContactType;
    private String typeNationalId;
    private String nationalId;
    private Boolean isCompanyPersonnel;
    private Boolean isAgent;
    private String specificPurposeId;

    public IndividualPartyDomain(UUID partyUuid, PTY_ENUM partyType, COU_ENUM country,
                                 String cultureCode, String timeZone, Date dayOfBirth,
                                 String gender, String maritalStatus) {
        super(partyUuid, partyType, country, cultureCode, timeZone);
        if (dayOfBirth == null || gender == null || maritalStatus == null) {
            throw new IllegalArgumentException("Individual-specific fields cannot be null");
        }
        this.dayOfBirth = dayOfBirth;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.isCompanyPersonnel = false;
        this.isAgent = false;
    }

    public void updatePersonalDetails(String gender, String maritalStatus, String profession) {
        if (gender != null) {
            this.gender = gender;
        }
        if (maritalStatus != null) {
            this.maritalStatus = maritalStatus;
        }
        if (profession != null) {
            this.profession = profession;
        }
    }


}
