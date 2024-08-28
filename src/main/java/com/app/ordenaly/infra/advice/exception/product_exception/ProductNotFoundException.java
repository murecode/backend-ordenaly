package com.app.ordenaly.infra.advice.exception.product_exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
