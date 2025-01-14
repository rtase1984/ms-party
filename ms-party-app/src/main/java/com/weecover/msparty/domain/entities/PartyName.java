package com.weecover.msparty.domain.entities;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
public abstract class PartyName extends BaseAuditEntity {

    @Column(name = "COUNTRY", length = 3)
    private String country;

}
