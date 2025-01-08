package com.weecover.msparty.domain.entities;

import lombok.*;


import javax.persistence.*;

@Table(name = "PARTY_PHONE", indexes = {
        @Index(name = "IDX_PARTY_PHONE_PARTY_ID", columnList = "PARTY_ID")
})
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PartyPhone extends BaseAuditEntity{

    @JoinColumn(name = "PARTY_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    private PartyHeader partyId;

    @Column(name = "PHONE_NUMBER", length = 15, nullable = false)
    private String phoneNumber;

    @Column(name = "IS_PRIMARY", nullable = false)
    private Boolean isPrimary = false;

}
