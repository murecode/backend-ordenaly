package com.app.ordenaly.model;

public record OrderCartData(String product, int quantity, int subtotal) {

  public OrderCartData(OrderCart orderCart) {
    this(
            orderCart.getProduct().getProductName(),
            orderCart.getQuantity(),
            orderCart.calculateSubtotal()
    );
  }

}
