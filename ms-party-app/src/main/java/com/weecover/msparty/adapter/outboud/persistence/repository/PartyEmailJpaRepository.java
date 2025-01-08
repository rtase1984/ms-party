package com.weecover.msparty.adapter.outboud.persistence.repository;

import com.weecover.msparty.domain.entities.PartyEmail;
import com.weecover.msparty.domain.port.PartyEmailRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PartyEmailJpaRepository extends JpaRepository<PartyEmail, UUID> {
    Optional<PartyEmail> findByEmailAndDeletedDateIsNull(String email);
}
