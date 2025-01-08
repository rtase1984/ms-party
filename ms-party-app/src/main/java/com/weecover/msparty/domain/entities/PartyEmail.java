package com.weecover.msparty.domain.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Date;


@Table(name = "PARTY_EMAIL")
@Entity
@Data
public class PartyEmail extends BaseAuditEntity{

    @ManyToOne(targetEntity = IndividualParty.class)
    @JoinColumn(name = "INDIVIDUAL_PARTY_ID")
    @JsonBackReference
    private IndividualParty individualParty;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EFFECTIVE_DATE", nullable = false)
    @NotNull
    private Date effectiveDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "EXPIRATION_DATE", nullable = false)
    @NotNull
    private Date expirationDate = new Date(Long.MAX_VALUE); // Default a 9999-12-31

    @Column(name = "EMAIL_TYPE", length = 3, nullable = false)
    @NotNull
    private String emailType;

    @Column(name = "EMAIL", length = 350, nullable = false)
    @NotNull
    @Email(message = "Invalid email format")
    private String email;

    @Column(name = "IS_PRIMARY", nullable = false)
    @NotNull
    private Boolean isPrimary = true;

    @Column(name = "COMMENTS")
    private String comments;
}
