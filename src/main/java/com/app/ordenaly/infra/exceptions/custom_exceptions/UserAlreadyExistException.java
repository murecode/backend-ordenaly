package com.app.ordenaly.infra.exceptions.custom_exceptions;

public class UserAlreadyExistException extends RuntimeException {
  public UserAlreadyExistException(String message) {
    super(message);
  }
}
