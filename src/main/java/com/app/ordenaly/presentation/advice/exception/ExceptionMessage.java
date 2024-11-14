package com.app.ordenaly.presentation.advice.exception;

public class ExceptionMessage {
  private String exception;
  private String message;
  private String path;

  public ExceptionMessage(Exception exception, String path) {
    this(
            exception.getClass().getSimpleName(),
            exception.getMessage(),
            path
    );
  }

  public ExceptionMessage(String exception, String message, String path) {
    this.exception = exception;
    this.message = message;
    this.path = path;
  }

  public String getException() {
    return exception;
  }

  public void setException(String exception) {
    this.exception = exception;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  @Override
  public String toString() {
    return "ExceptionMessage{" +
            "exception='" + exception + '\'' +
            ", message='" + message + '\'' +
            ", path='" + path + '\'' +
            '}';
  }
}
