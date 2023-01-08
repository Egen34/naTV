package com.example.naTV.exception;

import com.example.naTV.models.response.ResponseExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice
public class ExceptionsHandler {

    @ExceptionHandler({NotFoundExcep.class})
    public ResponseEntity<?> handleCreateEntityException(NotFoundExcep ex) {
        return new ResponseEntity(ResponseExceptions.getErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
}
