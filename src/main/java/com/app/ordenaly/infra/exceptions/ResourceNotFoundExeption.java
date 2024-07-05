package com.app.ordenaly.infra.exceptions;

public class ResourceNotFoundExeption extends RuntimeException {
  public ResourceNotFoundExeption(String msg) {
    super(msg);
  }
}
