package com.db.grad.javaapi.exception;

public class InvalidUserException extends RuntimeException{
    public InvalidUserException(String message){
        super(message);
    }
}
