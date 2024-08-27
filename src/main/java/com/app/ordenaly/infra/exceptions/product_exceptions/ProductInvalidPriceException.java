package com.app.ordenaly.infra.exceptions.product_exceptions;

public class ProductInvalidPriceException extends RuntimeException {
    public ProductInvalidPriceException(String message) {
        super(message);
    }
}
