package com.lmca.learnerService.exception;

public class EmailAlreadyExistsException extends RuntimeException{
    public EmailAlreadyExistsException(String message){
        super(message);
    }
}
