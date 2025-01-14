package com.weecover.msparty.adapter.inboud.rest;

import com.weecover.msparty.adapter.inboud.rest.dto.FullPartyRequestDto;
import com.weecover.msparty.adapter.inboud.rest.dto.dto.ApiResponseDto;
import com.weecover.msparty.adapter.outboud.FullPartyServiceImp;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/party")
@AllArgsConstructor
public class FullPartyRestController {

    private final FullPartyServiceImp partyService;

    @PostMapping
    public ResponseEntity<ApiResponseDto> saveParty(@RequestBody FullPartyRequestDto request){
        ApiResponseDto<?> response = partyService.saveParty(request);

        HttpStatus status = response.status().equals("created")
                ? HttpStatus.CREATED
                : HttpStatus.CONFLICT;

        return ResponseEntity.status(status).body(response);
    }


    @GetMapping("/{uuid}")
    public ResponseEntity<ApiResponseDto<?>> getPartyByUuid(@PathVariable UUID uuid) {
        return ResponseEntity.ok(partyService.getPartyById(uuid));
    }
}
