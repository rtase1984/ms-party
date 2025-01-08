package com.weecover.msparty.domain.port;

import com.weecover.msparty.domain.entities.IndividualParty;


import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface IndividualPartyRepository {

    Optional<IndividualParty> findById(UUID id);

    IndividualParty saveIndividualParty(IndividualParty individualParty);

    List<IndividualParty> findByGender(String gender);

    List<IndividualParty> findByProfession(String profession);

    List<IndividualParty> findByFamilyNamesAndDeletedDateIsNull(String firstFamilyName, String secondFamilyName);

    List<IndividualParty> findByLastNameAndDeletedDateIsNull(String lastName);
}