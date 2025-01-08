package com.weecover.msparty.adapter.inboud.rest;

import com.weecover.msparty.adapter.inboud.rest.dto.MsPartyRequest;
import com.weecover.msparty.domain.usecase.MsPartyCommandUseCase;
import com.weecover.msparty.domain.model.MsParty;
import org.springframework.core.convert.ConversionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequestMapping("/msPartys")
public class MsPartysRestController {

    private final ConversionService conversionService;
    private final MsPartyCommandUseCase msPartyCommandUseCase;

    public MsPartysRestController(final MsPartyCommandUseCase msPartyCommandUseCase,
                                    final ConversionService conversionService) {
        this.conversionService = conversionService;
        this.msPartyCommandUseCase = msPartyCommandUseCase;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody @Valid final MsPartyRequest msPartyRequest) {
        final var msParty = conversionService.convert(msPartyRequest, MsParty.class);
        msPartyCommandUseCase.command(msParty);
        return ResponseEntity.status(CREATED).build();
    }
}
