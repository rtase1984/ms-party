package com.weecover.msparty.domain.port;

import com.weecover.msparty.domain.entities.PartyEmail;

import java.util.Optional;

public interface PartyEmailRepository {
    PartyEmail saveEmail(PartyEmail email);
    Optional<PartyEmail> findByEmailAndDeletedDateIsNull(String email);
}
