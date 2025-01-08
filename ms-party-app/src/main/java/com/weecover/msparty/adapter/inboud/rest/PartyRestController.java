package com.weecover.msparty.adapter.inboud.rest;


import com.weecover.msparty.adapter.inboud.rest.converter.PartyMapper;
import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.outboud.PartyServiceImpl;
import com.weecover.msparty.adapter.outboud.persistence.dto.PartyResponseDto;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/party")
public class PartyRestController {
    private final PartyMapper partyMapper;

    private final PartyServiceImpl partyService;

    public PartyRestController(PartyServiceImpl partyService, PartyMapper partyMapper) {
        this.partyService = partyService;
        this.partyMapper = partyMapper;
    }

    @PostMapping
    public ResponseEntity<PartyResponseDto> createParty(@Valid @RequestBody PartyRequestDto partyRequest) {
        try {
            PartyResponseDto response = partyService.createIndividualParty(partyRequest);

            // Decidir el estado HTTP según el "status" del DTO
            switch (response.getStatus()) {
                case "created":
                    return ResponseEntity.status(HttpStatus.CREATED).body(response);
                case "accepted":
                    return ResponseEntity.status(HttpStatus.ACCEPTED).body(response);
                case "error":
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
                default:
                    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
            }
        } catch (UnauthorizedAccessException ex) {
            // Manejo específico de errores de autorización
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(new PartyResponseDto("error", ex.getMessage(), null, null, null));
        } catch (Exception ex) {
            // Manejo de errores genéricos
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new PartyResponseDto("error", "Error interno del servidor: " + ex.getMessage(), null, null, null));
        }
    }

}
