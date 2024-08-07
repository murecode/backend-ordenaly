package com.app.ordenaly.infra.exceptions;

import com.app.ordenaly.infra.exceptions.custom_exceptions.ResourceNotFoundExeption;
import com.app.ordenaly.infra.exceptions.custom_exceptions.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HttpExceptionHandler {

  @ExceptionHandler({
          ResourceNotFoundExeption.class,
  })
  public ResponseEntity<ExceptionMessage> handleNotfound(Exception exeption) {
    ExceptionMessage exceptionMessage = new ExceptionMessage(
            exeption,
            exeption.getMessage()
    );
    return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
          UserAlreadyExistException.class,
  })
  public ResponseEntity<ExceptionMessage> handleBadRequest(Exception exception) {
    ExceptionMessage exceptionMessage = new ExceptionMessage(
            exception,
            exception.getMessage()
    );
    return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
  }

}
