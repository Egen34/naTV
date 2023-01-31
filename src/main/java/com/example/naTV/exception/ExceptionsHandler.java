package com.example.naTV.exception;

import com.example.naTV.models.response.ResponseExceptions;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
@ControllerAdvice(basePackages = "com.example.naTV.controller")
public class ExceptionsHandler {

    @ExceptionHandler({NotFoundExcep.class})
    public ResponseEntity<?> handleCreateEntityException(NotFoundExcep ex) {
        return new ResponseEntity(ResponseExceptions.getErrorResponse(ex.getMessage()), HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler({MicroServiceException.class})
    public ResponseEntity<?> handleCreateEntityException(MicroServiceException ex){
        return new ResponseEntity(ResponseExceptions.getErrorResponse(ex.getMessage()), HttpStatus.CONFLICT);

    }
    @ExceptionHandler({Save4Exception.class})
    public ResponseEntity<?> handleCreateEntityException(Save4Exception ex){
        return new ResponseEntity(ResponseExceptions.getErrorResponse(ex.getMessage()), HttpStatus.CONFLICT);

    }
//    @ExceptionHandler({RuntimeException.class})
//    public ResponseEntity<?> handleCreateEntityException(RuntimeException ex){
//        return new ResponseEntity(ResponseExceptions.getErrorResponse(ex.getMessage()), HttpStatus.I_AM_A_TEAPOT);
//
//    }
}
