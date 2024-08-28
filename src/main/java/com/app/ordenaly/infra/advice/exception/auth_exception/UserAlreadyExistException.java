package com.app.ordenaly.infra.advice.exception.auth_exception;

public class UserAlreadyExistException extends RuntimeException {
    public UserAlreadyExistException(String message) {
        super(message);
    }
}
