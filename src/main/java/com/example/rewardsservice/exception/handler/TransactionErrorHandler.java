package com.example.rewardsservice.exception.handler;

import com.example.rewardsservice.exception.ErrorDetails;
import com.example.rewardsservice.exception.TransactionNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TransactionErrorHandler {

    /**
     * In case of TransactionNotFoundException is thrown
     * from any controller method, this logic gets executed
     * @param nfe
     * @return ResponseEntity
     */
    //@ResponseBody
    @ExceptionHandler(TransactionNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleNotFound(TransactionNotFoundException nfe){

        return new ResponseEntity<ErrorDetails>(
                new ErrorDetails(
                        LocalDateTime.now(),
                        "404- NOT FOUND",
                        nfe.getMessage()),
                HttpStatus.NOT_FOUND);
    }

}
