package com.app.ordenaly.infra.advice.exception.order_exception;

public class OrderNotFoundException extends RuntimeException {
    public OrderNotFoundException(String message) {
        super(message);
    }
}
