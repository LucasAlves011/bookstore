package com.principal.resources.exceptions;

import com.principal.service.excepcions.DataIntegrityViolationException;
import com.principal.service.excepcions.ObjectNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.ServletRequest;
import java.time.Clock;
import java.time.LocalDateTime;
import java.time.OffsetDateTime;
import java.time.ZoneId;

@ControllerAdvice
public class ResourceExceptionHandler {
    /*
        Estou percebendo que essas exceptions tendem a ter um formato padrão, geralmente só precisa fazer algumas
        pequenas alterações.
     */

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFoundException(ObjectNotFoundException e, ServletRequest request){
        StandardError error = new StandardError(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.NOT_FOUND.value()
        , e.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<StandardError> dataIntegrityViolationException(DataIntegrityViolationException e, ServletRequest request){
        StandardError error = new StandardError(LocalDateTime.now(ZoneId.of("UTC")), HttpStatus.BAD_REQUEST.value()
                , e.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

}
