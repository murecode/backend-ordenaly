package com.app.ordenaly.infra.exceptions.custom_exceptions;

public class ResourceNotFoundExeption extends RuntimeException {
  public ResourceNotFoundExeption(String message) {
    super(message);
  }
}
