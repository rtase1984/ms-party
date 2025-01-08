package com.weecover.msparty.adapter.inboud.rest.dto;

public record IndividualPartyNameDto(
        String nameType,
        String firstName,
        String middleName,
        String firstFamilyName,
        String secondFamilyName,
        String lastName
) {

}
