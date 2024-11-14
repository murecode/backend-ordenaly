package com.app.ordenaly.presentation.advice.exception.auth_exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
