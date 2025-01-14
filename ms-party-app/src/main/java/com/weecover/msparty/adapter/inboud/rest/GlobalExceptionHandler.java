package com.weecover.msparty.adapter.inboud.rest;

import com.weecover.msparty.adapter.outboud.dto.PartyResponseDto;
import com.weecover.msparty.domain.exception.DuplicatePartyException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class GlobalExceptionHandler {

        @ExceptionHandler(DuplicatePartyException.class)
        public ResponseEntity<PartyResponseDto> handleDuplicatePartyException(DuplicatePartyException ex) {
            PartyResponseDto response = new PartyResponseDto();
            response.setStatus("error");
            response.setMessage("Duplicados encontrados: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
        }

        @ExceptionHandler(UnauthorizedAccessException.class)
        public ResponseEntity<PartyResponseDto> handleUnauthorizedAccessException(UnauthorizedAccessException ex) {
            PartyResponseDto response = new PartyResponseDto();
            response.setStatus("error");
            response.setMessage("Acceso no autorizado: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(response);
        }

        @ExceptionHandler(Exception.class)
        public ResponseEntity<PartyResponseDto> handleGenericException(Exception ex) {
            PartyResponseDto response = new PartyResponseDto();
            response.setStatus("error");
            response.setMessage("Error interno del servidor: " + ex.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
        }
}
