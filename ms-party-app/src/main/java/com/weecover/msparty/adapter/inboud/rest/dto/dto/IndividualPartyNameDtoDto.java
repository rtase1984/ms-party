package com.weecover.msparty.adapter.inboud.rest.dto.dto;

public record IndividualPartyNameDtoDto(
     String nameType,
     String namePrefix,
     String firstName,
     String nameSufix,
     String phoneticFirstName,
     String soundexFirstName,
     String middleName,
     String phoneticMiddleName,
     String soundexMiddleName,
     String lastName,
     String phoneticLastName,
     String soundexLastName,
     String firstFamilyName,
     String phoneticFirstFamilyName,
     String soundexFirstFamilyName,
     String secondFamilyName,
     String phoneticSecondFamilyName,
     String soundexSecondFamilyName,
     String otherFamilyName,
     String phoneticOtherFamilyName,
     String soundexOtherFamilyName,
     String fullName,
     String comments
) implements PartyNameDto {}