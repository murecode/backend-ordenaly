package com.app.ordenaly.model.response;

import com.app.ordenaly.model.entities.OrderCart;

public record OrderCartData(
        String product,
        int quantity,
        int subtotal
) {

  public OrderCartData(OrderCart orderCart) {
    this(
            orderCart.getProduct().getTitle(),
            orderCart.getQuantity(),
            orderCart.calculateSubtotal()
    );
  }

}
