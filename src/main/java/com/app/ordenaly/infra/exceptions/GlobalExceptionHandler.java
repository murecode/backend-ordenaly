package com.app.ordenaly.infra.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.app.ordenaly.infra.exceptions.auth_exceptions.UserAlreadyExistException;
import com.app.ordenaly.infra.exceptions.product_exceptions.ProductAlreadyExistException;
import com.app.ordenaly.infra.exceptions.product_exceptions.ProductNotFoundException;
import com.app.ordenaly.infra.exceptions.product_exceptions.ProductInvalidPriceException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({
          ProductNotFoundException.class
  })
  public ResponseEntity<ExceptionMessage> NotFoundException(Exception exeption, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exeption, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.NOT_FOUND);
  }

  @ExceptionHandler({
          UserAlreadyExistException.class,
          ProductAlreadyExistException.class
  })
  public ResponseEntity<ExceptionMessage> ResourceAlreadyExistException(Exception exception, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exception, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.CONFLICT);
  }

  @ExceptionHandler({})
  public ResponseEntity<ExceptionMessage> UnauthorizedAccessException(Exception exception, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exception, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler({
          ProductInvalidPriceException.class
  })
  public ResponseEntity<ExceptionMessage> InvalidInputException(Exception exception, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exception, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
  }


  /*@ExceptionHandler({})
  public ResponseEntity<ExceptionMessage> AccessDeniedException(Exception exception, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exception, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.FORBIDDEN);
  }*/


}
