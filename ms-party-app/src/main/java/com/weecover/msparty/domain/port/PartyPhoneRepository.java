package com.weecover.msparty.domain.port;

import com.weecover.msparty.domain.entities.PartyPhone;

import java.util.Optional;

public interface PartyPhoneRepository {
    PartyPhone savePhone(PartyPhone phone);
    Optional<PartyPhone> findByPhoneNumberAndDeletedDateIsNull(String phone);
}
