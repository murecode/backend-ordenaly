package com.app.ordenaly.infra.exceptions;

import com.app.ordenaly.infra.exceptions.custom_exceptions.ResourceNotFoundExeption;
import com.app.ordenaly.infra.exceptions.custom_exceptions.UserAlreadyExistException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({
          ResourceNotFoundExeption.class,
  })
  public ResponseEntity<ExceptionMessage> handleNotfound(Exception exeption, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exeption, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
          UserAlreadyExistException.class,
  })
  public ResponseEntity<ExceptionMessage> handleBadRequest(Exception exception, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exception, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
  }

//  @ExceptionHandler({})
//  public ResponseEntity<ExceptionMessage> handleForbiddenRequest() {
//    return null;
//  }
//
//  @ExceptionHandler({})
//  public ResponseEntity<ExceptionMessage> handleUnauthorizedRequest() {
//    return null;
//  }



}
