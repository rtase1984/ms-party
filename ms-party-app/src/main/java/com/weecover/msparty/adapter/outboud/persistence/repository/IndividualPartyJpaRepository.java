package com.weecover.msparty.adapter.outboud.persistence.repository;

import com.weecover.msparty.domain.entities.IndividualParty;
import com.weecover.msparty.domain.port.IndividualPartyRepository;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IndividualPartyJpaRepository extends JpaRepository<IndividualParty, UUID>, IndividualPartyRepository {
    IndividualParty saveIndividualParty(IndividualParty individualParty);
    List<IndividualParty> findByGender(String gender);
    List<IndividualParty> findByProfession(String profession);
    List<IndividualParty> findByFamilyNamesAndDeletedDateIsNull(String firstFamilyName, String secondFamilyName);
    List<IndividualParty> findByLastNameAndDeletedDateIsNull(String lastName);
}
