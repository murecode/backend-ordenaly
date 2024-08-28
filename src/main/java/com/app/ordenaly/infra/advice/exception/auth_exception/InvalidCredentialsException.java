package com.app.ordenaly.infra.advice.exception.auth_exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
