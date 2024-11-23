package com.app.ordenaly.presentation.advice.exception;

import com.app.ordenaly.presentation.advice.exception.auth_exception.InvalidCredentialsException;
import com.app.ordenaly.presentation.advice.exception.auth_exception.UserNotFoundException;
import com.app.ordenaly.presentation.advice.exception.order_exception.OrderNotFoundException;
import com.app.ordenaly.presentation.advice.exception.ticket_exception.NumberOfPeopleException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import com.app.ordenaly.presentation.advice.exception.auth_exception.UserAlreadyExistException;
import com.app.ordenaly.presentation.advice.exception.product_exception.ProductAlreadyExistException;
import com.app.ordenaly.presentation.advice.exception.product_exception.ProductNotFoundException;
import com.app.ordenaly.presentation.advice.exception.product_exception.ProductInvalidPriceException;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler({
          ProductNotFoundException.class,
          OrderNotFoundException.class,
          UserNotFoundException.class
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

  @ExceptionHandler({
          ProductInvalidPriceException.class,
          NumberOfPeopleException.class
  })
  public ResponseEntity<ExceptionMessage> InvalidInputException(Exception exception, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exception, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.BAD_REQUEST);
  }

  @ExceptionHandler({
          InvalidCredentialsException.class
  })
  public ResponseEntity<ExceptionMessage> UnauthorizedAccessException(Exception exception, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exception, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.UNAUTHORIZED);
  }

  @ExceptionHandler({

  })
  public ResponseEntity<ExceptionMessage> AccessDeniedException(Exception exception, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exception, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.FORBIDDEN);
  }




  /*@ExceptionHandler({})
  public ResponseEntity<ExceptionMessage> AccessDeniedException(Exception exception, WebRequest request) {
    String path = request.getDescription(false).replace("uri=", "");
    ExceptionMessage exceptionMessage = new ExceptionMessage(exception, path);
    return new ResponseEntity<>(exceptionMessage, HttpStatus.FORBIDDEN);
  }*/


}
