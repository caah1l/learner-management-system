package com.lmca.learnerService.exception;

public class LearnerNotFoundException extends RuntimeException{
    public LearnerNotFoundException(String message){
        super(message);
    }
}
