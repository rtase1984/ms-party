package com.weecover.msparty.domain.usecase;

import com.weecover.msparty.domain.model.MsParty;
import com.weecover.msparty.provider.MsPartyRepository;
import com.weecover.msparty.provider.ThirdPartyProvider;
import com.weecover.boot.base.exception.BusinessException;
import org.springframework.stereotype.Service;

@Service
public class MsPartyCommandUseCase {

    private final MsPartyRepository msPartyRepository;
    private final ThirdPartyProvider thirdPartyProvider;

    public MsPartyCommandUseCase(final MsPartyRepository msPartyRepository,
                                   final ThirdPartyProvider thirdPartyProvider) {
        this.msPartyRepository = msPartyRepository;
        this.thirdPartyProvider = thirdPartyProvider;
    }

    public void command(final MsParty msParty) {
        if (msParty.getValue() > 100) {
            throw new BusinessException("msParty.business.error", 100);
        }

        thirdPartyProvider.evaluate(msParty);
        msPartyRepository.create(msParty);
    }
}
