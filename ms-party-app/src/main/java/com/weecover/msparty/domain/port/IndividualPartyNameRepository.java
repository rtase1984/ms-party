package com.weecover.msparty.domain.port;

import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.entities.IndividualPartyName;

import java.util.List;
import java.util.Optional;


public interface IndividualPartyNameRepository {
   IndividualPartyName saveName(IndividualPartyName name);
   List<IndividualParty> findByFamilyNamesAndDeletedDateIsNull(String firstFamilyName, String secondFamilyName);
}
