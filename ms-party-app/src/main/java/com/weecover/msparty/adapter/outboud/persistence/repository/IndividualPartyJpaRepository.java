package com.weecover.msparty.adapter.outboud.persistence.repository;

import com.weecover.msparty.domain.entities.IndividualParty;
import org.jetbrains.annotations.NotNull;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface IndividualPartyJpaRepository extends JpaRepository<IndividualParty, UUID> {

    List<IndividualParty> findByGender(String gender);
    List<IndividualParty> findByProfession(String profession);

    @Override
    Optional<IndividualParty> findById(@NotNull UUID uuid);
    Optional<IndividualParty> findByIdAndDeletedDateIsNull(@NotNull UUID uuid);
}
