package com.weecover.msparty.adapter.inboud.rest;

import com.weecover.msparty.adapter.inboud.rest.dto.PartyRequestDto;
import com.weecover.msparty.adapter.outboud.PartyServiceOldImpl;
import com.weecover.msparty.adapter.outboud.dto.PartyResponseDto;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/api/party")
public class PartyRestController {

    private final PartyServiceOldImpl partyService;

    @PostMapping
    public ResponseEntity<PartyResponseDto> createParty(@Valid @RequestBody PartyRequestDto partyRequest) {
        PartyResponseDto response = partyService.createIndividualParty(partyRequest);
        return ResponseEntity.status(getHttpStatusFromResponse(response)).body(response);
    }

    /*@GetMapping("/{id}")
    public ResponseEntity<?> getPartyById(@PathVariable UUID id) {
        return partyService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }*/

    /**
     * Determina el estado HTTP basado en el "status" del DTO de respuesta.
     */
    private HttpStatus getHttpStatusFromResponse(PartyResponseDto response) {
        switch (response.getStatus()) {
            case "created":
                return HttpStatus.CREATED;
            case "accepted":
                return HttpStatus.ACCEPTED;
            case "error":
                return HttpStatus.BAD_REQUEST;
            default:
                return HttpStatus.INTERNAL_SERVER_ERROR;
        }
    }

}
