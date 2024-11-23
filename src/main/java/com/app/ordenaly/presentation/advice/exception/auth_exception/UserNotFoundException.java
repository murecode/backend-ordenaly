package com.app.ordenaly.presentation.advice.exception.auth_exception;

public class UserNotFoundException extends RuntimeException {
  public UserNotFoundException(String message) {
    super(message);
  }
}
