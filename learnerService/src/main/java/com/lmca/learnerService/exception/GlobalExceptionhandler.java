package com.lmca.learnerService.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionhandler {

    private static final Logger log = LoggerFactory.getLogger(GlobalExceptionhandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String,String>> handleValidationException(MethodArgumentNotValidException ex){
        Map<String,String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(
                x -> errors.put(x.getField(),x.getDefaultMessage())
        );

        return ResponseEntity.badRequest().body(errors);
    }

    @ExceptionHandler(EmailAlreadyExistsException.class)
    public ResponseEntity<Map<String,String>> validateEmailId(EmailAlreadyExistsException ex){

        log.warn("Email already exists {}", ex.getMessage());

        Map<String,String> errors = new HashMap<>();
        errors.put("Message","Email already Exists");

        return ResponseEntity.badRequest().body(errors);
    }
}
