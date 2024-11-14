package com.app.ordenaly.presentation.advice.exception.product_exception;

public class ProductNotFoundException extends RuntimeException {
    public ProductNotFoundException(String message) {
        super(message);
    }
}
