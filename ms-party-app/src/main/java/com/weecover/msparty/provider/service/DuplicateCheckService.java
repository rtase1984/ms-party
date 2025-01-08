package com.weecover.msparty.provider.service;

import com.weecover.msparty.domain.port.PartyRepository;
import org.springframework.stereotype.Service;

@Service
public class DuplicateCheckService {
    private final PartyRepository partyRepository;

    public DuplicateCheckService(PartyRepository partyRepository) {
        this.partyRepository = partyRepository;
    }



}
