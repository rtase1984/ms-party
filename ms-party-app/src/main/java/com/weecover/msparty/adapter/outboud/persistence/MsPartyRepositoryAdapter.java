package com.weecover.msparty.adapter.outboud.persistence;

import com.weecover.msparty.adapter.outboud.persistence.dto.MsPartyEntity;
import com.weecover.msparty.adapter.outboud.persistence.repository.PostgresMsPartyEntityRepository;
import com.weecover.msparty.domain.model.MsParty;
import com.weecover.msparty.provider.MsPartyRepository;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Component;

@Component
public class MsPartyRepositoryAdapter implements MsPartyRepository {

    private final PostgresMsPartyEntityRepository repository;
    private final ConversionService conversionService;

    public MsPartyRepositoryAdapter(final PostgresMsPartyEntityRepository repository,
                                      final ConversionService conversionService) {
        this.repository = repository;
        this.conversionService = conversionService;
    }

    @Override
    public void create(final MsParty msParty) {
        final var msPartyEntity = conversionService.convert(msParty, MsPartyEntity.class);
        repository.save(msPartyEntity);
    }
}
