package com.blog.example.blog.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

import com.blog.example.blog.domain.dtos.ApIErrorResponse;

import lombok.extern.slf4j.Slf4j;

@RestController
@ControllerAdvice
@Slf4j
public class ErrorController {
    
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApIErrorResponse> handleException(Exception ex) {
        log.error("Exception occurred: {}", ex.getMessage());
        ApIErrorResponse error = ApIErrorResponse.builder()
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message("An unexpected error occurred")
            .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
    
    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApIErrorResponse> handleIllegalArgumentException(IllegalArgumentException ex) {
        log.error("IllegalArgumentException occurred: {}", ex.getMessage());
        ApIErrorResponse error = ApIErrorResponse.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .message(ex.getMessage())
            .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<ApIErrorResponse> handleIllegalStateException(IllegalStateException ex) {
        log.error("IllegalStateException occurred: {}", ex.getMessage());
        ApIErrorResponse error = ApIErrorResponse.builder()
            .status(HttpStatus.CONFLICT.value())
            .message(ex.getMessage())
            .build();
        return ResponseEntity.status(HttpStatus.CONFLICT).body(error);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ApIErrorResponse> handleUsernameNotFoundException(UsernameNotFoundException ex) {
        log.error("UsernameNotFoundException occurred: {}", ex.getMessage());
        ApIErrorResponse error = ApIErrorResponse.builder()
            .status(HttpStatus.NOT_FOUND.value())
            .message(ex.getMessage())
            .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

}
