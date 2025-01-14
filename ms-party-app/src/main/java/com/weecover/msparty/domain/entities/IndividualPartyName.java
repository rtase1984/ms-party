package com.weecover.msparty.domain.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import javax.validation.constraints.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Table(name = "INDIVIDUAL_PARTY_NAME")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class IndividualPartyName extends PartyName {

    @ManyToOne(targetEntity = IndividualParty.class)
    @JoinColumn(name = "INDIVIDUAL_PARTY_ID")
    @JsonBackReference
    private IndividualParty individualParty;

    @Column(name = "NAME_TYPE", length = 3)
    private String nameType;

    @Column(name = "NAME_PREFIX", length = 3)
    private String namePrefix;

    @Column(name = "FIRST_NAME", length = 100)
    @NotNull
    private String firstName;

    @Column(name = "NAME_SUFIX", length = 5)
    private String nameSufix;

    @Column(name = "PHONETIC_FIRST_NAME")
    private String phoneticFirstName;

    @Column(name = "SOUNDEX_FIRST_NAME", length = 4)
    private String soundexFirstName;

    @Column(name = "MIDDLE_NAME", length = 100)
    private String middleName;

    @Column(name = "PHONETIC_MIDDLE_NAME")
    private String phoneticMiddleName;

    @Column(name = "SOUNDEX_MIDDLE_NAME", length = 4)
    private String soundexMiddleName;

    @Column(name = "LAST_NAME", length = 100)
    private String lastName;

    @Column(name = "PHONETIC_LAST_NAME")
    private String phoneticLastName;

    @Column(name = "SOUNDEX_LAST_NAME", length = 4)
    private String soundexLastName;

    @Column(name = "FIRST_FAMILY_NAME", length = 100)
    private String firstFamilyName;

    @Column(name = "PHONETIC_FIRST_FAMILY_NAME")
    private String phoneticFirstFamilyName;

    @Column(name = "SOUNDEX_FIRST_FAMILY_NAME", length = 4)
    private String soundexFirstFamilyName;

    @Column(name = "SECOND_FAMILY_NAME", length = 100)
    private String secondFamilyName;

    @Column(name = "PHONETIC_SECOND_FAMILY_NAME")
    private String phoneticSecondFamilyName;

    @Column(name = "SOUNDEX_SECOND_FAMILY_NAME", length = 4)
    private String soundexSecondFamilyName;

    @Column(name = "OTHER_FAMILY_NAME", length = 100)
    private String otherFamilyName;

    @Column(name = "PHONETIC_OTHER_FAMILY_NAME")
    private String phoneticOtherFamilyName;

    @Column(name = "SOUNDEX_OTHER_FAMILY_NAME", length = 4)
    private String soundexOtherFamilyName;

    @Column(name = "FULL_NAME")
    private String fullName;

    @Column(name = "COMMENTS")
    private String comments;

}
