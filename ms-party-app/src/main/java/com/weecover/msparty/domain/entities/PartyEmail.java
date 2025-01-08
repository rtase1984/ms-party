package com.weecover.msparty.domain.entities;


import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.time.OffsetDateTime;
import java.util.Date;
import java.util.UUID;


@Table(name = "PARTY_EMAIL")
@Entity
@Data
public class PartyEmail extends BaseAuditEntity{

    @JoinColumn(name = "PARTY_ID", nullable = false)
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @NotNull
    private PartyHeader partyId; // Relación con PartyHeader

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
