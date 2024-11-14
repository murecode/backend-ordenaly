package com.app.ordenaly.presentation.advice.exception.auth_exception;

public class InvalidCredentialsException extends RuntimeException {
    public InvalidCredentialsException(String message) {
        super(message);
    }
}
