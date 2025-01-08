package com.weecover.msparty.domain.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Table(name = "INDIVIDUAL_PARTY_NAME")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class IndividualPartyName extends PartyName {

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
    @NotNull
    private String soundexFirstName;

    @Column(name = "MIDDLE_NAME", length = 100)
    private String middleName;

    @Column(name = "PHONETIC_MIDDLE_NAME")
    private String phoneticMiddleName;

    @Column(name = "SOUNDEX_MIDDLE_NAME", length = 4)
    @NotNull
    private String soundexMiddleName;

    @Column(name = "LAST_NAME", length = 100)
    @NotNull
    private String lastName;

    @Column(name = "PHONETIC_LAST_NAME")
    private String phoneticLastName;

    @Column(name = "SOUNDEX_LAST_NAME", length = 4)
    @NotNull
    private String soundexLastName;

    @Column(name = "FIRST_FAMILY_NAME", length = 100)
    private String firstFamilyName;

    @Column(name = "PHONETIC_FIRST_FAMILY_NAME")
    private String phoneticFirstFamilyName;

    @Column(name = "SOUNDEX_FIRST_FAMILY_NAME", length = 4)
    @NotNull
    private String soundexFirstFamilyName;

    @Column(name = "SECOND_FAMILY_NAME", length = 100)
    private String secondFamilyName;

    @Column(name = "PHONETIC_SECOND_FAMILY_NAME")
    private String phoneticSecondFamilyName;

    @Column(name = "SOUNDEX_SECOND_FAMILY_NAME", length = 4)
    @NotNull
    private String soundexSecondFamilyName;

    @Column(name = "OTHER_FAMILY_NAME", length = 100)
    private String otherFamilyName;

    @Column(name = "PHONETIC_OTHER_FAMILY_NAME")
    private String phoneticOtherFamilyName;

    @Column(name = "SOUNDEX_OTHER_FAMILY_NAME", length = 4)
    @NotNull
    private String soundexOtherFamilyName;

    @Column(name = "FULL_NAME")
    @NotNull
    private String fullName;

    @Column(name = "COMMENTS")
    private String comments;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "LAST_UPDATE")
    private Date lastUpdate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PARTY_ID", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    private IndividualParty individualParty;
}
