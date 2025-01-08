package com.weecover.msparty.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;


@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class PartyName extends BaseAuditEntity{

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "PARTY_UUID", nullable = false)
    @OnDelete(action = OnDeleteAction.NO_ACTION)
    @JsonBackReference
    private PartyHeader party;

    @Column(name = "COUNTRY", length = 3)
    private String country;

}
