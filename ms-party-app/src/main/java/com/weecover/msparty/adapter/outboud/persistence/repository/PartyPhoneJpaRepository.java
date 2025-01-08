package com.weecover.msparty.adapter.outboud.persistence.repository;

import com.weecover.msparty.domain.entities.PartyPhone;
import com.weecover.msparty.domain.port.PartyPhoneRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PartyPhoneJpaRepository extends JpaRepository<PartyPhone, UUID> {
    Optional<PartyPhone> findByPhoneNumberAndDeletedDateIsNull(String phone);
}
