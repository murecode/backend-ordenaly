package com.app.ordenaly.infra.advice.exception.product_exception;

public class ProductInvalidPriceException extends RuntimeException {
    public ProductInvalidPriceException(String message) {
        super(message);
    }
}
