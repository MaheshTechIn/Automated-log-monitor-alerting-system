package com.project.logMonitor.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class GlobalExceptionHandler {

    public ResponseEntity<String> handleException(Exception ex){

        return new ResponseEntity<>(
                "something went wrong" +ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR
        );
    }
}
