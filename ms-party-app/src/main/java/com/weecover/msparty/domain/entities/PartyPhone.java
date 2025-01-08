package com.weecover.msparty.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;


import javax.persistence.*;

@Table(name = "PARTY_PHONE")
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartyPhone extends BaseAuditEntity{

    @ManyToOne(targetEntity = IndividualParty.class)
    @JoinColumn(name = "INDIVIDUAL_PARTY_ID")
    @JsonBackReference
    private IndividualParty individualParty;

    @Column(name = "PHONE_NUMBER", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "IS_PRIMARY", nullable = false)
    private Boolean isPrimary = false;

}
