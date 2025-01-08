package com.weecover.msparty.domain.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

public class BusinessPartyDomain extends PartyHeaderDomain {
    private LocalDate effectiveDate;
    private LocalDateTime expirationDate;
    private BPT_ENUM businessType;
    private String preferredLanguage;
    private CON_ENUM preferredContactType;
    private boolean isAgency;
    private boolean isSupplier;
    private REG_ENUM registrationType;
    private String registrationId;
    private boolean isDeleted;

    // Constructor completo para instanciación
    public BusinessPartyDomain(UUID partyUuid, PTY_ENUM partyType, COU_ENUM country,
                               String cultureCode, String timeZone, LocalDate effectiveDate,
                               LocalDateTime expirationDate, BPT_ENUM businessType,
                               String preferredLanguage, CON_ENUM preferredContactType,
                               boolean isAgency, boolean isSupplier,
                               REG_ENUM registrationType, String registrationId,
                               boolean isDeleted) {
        super(partyUuid, partyType, country, cultureCode, timeZone);
        this.effectiveDate = Objects.requireNonNull(effectiveDate, "Effective date is required");
        this.expirationDate = Objects.requireNonNull(expirationDate, "Expiration date is required");
        this.businessType = businessType;
        this.preferredLanguage = preferredLanguage;
        this.preferredContactType = preferredContactType;
        this.isAgency = isAgency;
        this.isSupplier = isSupplier;
        this.registrationType = Objects.requireNonNull(registrationType, "Registration type is required");
        this.registrationId = Objects.requireNonNull(registrationId, "Registration ID is required");
        this.isDeleted = isDeleted;
    }

    // Métodos para lógica de negocio
    public boolean isActive() {
        LocalDateTime now = LocalDateTime.now();
        return now.isAfter(effectiveDate.atStartOfDay()) && now.isBefore(expirationDate) && !isDeleted;
    }

    public void markAsDeleted() {
        this.isDeleted = true;
    }

    public void updateBusinessDetails(BPT_ENUM businessType, String preferredLanguage, CON_ENUM preferredContactType) {
        this.businessType = businessType;
        this.preferredLanguage = preferredLanguage;
        this.preferredContactType = preferredContactType;
    }

    // Getters y Setters relevantes
    public LocalDate getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(LocalDate effectiveDate) {
        this.effectiveDate = Objects.requireNonNull(effectiveDate, "Effective date cannot be null");
    }

    public LocalDateTime getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(LocalDateTime expirationDate) {
        this.expirationDate = Objects.requireNonNull(expirationDate, "Expiration date cannot be null");
    }

    public BPT_ENUM getBusinessType() {
        return businessType;
    }

    public void setBusinessType(BPT_ENUM businessType) {
        this.businessType = businessType;
    }

    public String getPreferredLanguage() {
        return preferredLanguage;
    }

    public void setPreferredLanguage(String preferredLanguage) {
        this.preferredLanguage = preferredLanguage;
    }

    public CON_ENUM getPreferredContactType() {
        return preferredContactType;
    }

    public void setPreferredContactType(CON_ENUM preferredContactType) {
        this.preferredContactType = preferredContactType;
    }

    public boolean isAgency() {
        return isAgency;
    }

    public void setAgency(boolean isAgency) {
        this.isAgency = isAgency;
    }

    public boolean isSupplier() {
        return isSupplier;
    }

    public void setSupplier(boolean isSupplier) {
        this.isSupplier = isSupplier;
    }

    public REG_ENUM getRegistrationType() {
        return registrationType;
    }

    public void setRegistrationType(REG_ENUM registrationType) {
        this.registrationType = Objects.requireNonNull(registrationType, "Registration type cannot be null");
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = Objects.requireNonNull(registrationId, "Registration ID cannot be null");
    }

    public boolean isDeleted() {
        return isDeleted;
    }

    public void setDeleted(boolean isDeleted) {
        this.isDeleted = isDeleted;
    }
}
