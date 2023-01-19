package com.example.rewardsservice.exception.handler;

import com.example.rewardsservice.exception.CustomerNotFoundException;
import com.example.rewardsservice.exception.ErrorDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class CustomerErrorHandler {

    /**
     * In case of CustomerNotFoundException is thrown
     * from any controller method, this logic gets executed
     * @param nfe
     * @return ResponseEntity
     */
    @ExceptionHandler(CustomerNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFound(CustomerNotFoundException nfe){

        return new ResponseEntity<ErrorDetails>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        "404- NOT FOUND",
                        nfe.getMessage()),
                HttpStatus.NOT_FOUND);
    }
}
