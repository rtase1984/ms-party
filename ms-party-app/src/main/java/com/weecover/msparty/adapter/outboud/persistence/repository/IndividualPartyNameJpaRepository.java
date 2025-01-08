package com.weecover.msparty.adapter.outboud.persistence.repository;

import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.entities.IndividualPartyName;
import com.weecover.msparty.domain.port.IndividualPartyNameRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface IndividualPartyNameJpaRepository extends JpaRepository<IndividualPartyName, UUID>, IndividualPartyNameRepository {
    IndividualPartyName saveName(IndividualPartyName name);
    List<IndividualParty> findByFamilyNamesAndDeletedDateIsNull(String firstFamilyName, String secondFamilyName);
}
