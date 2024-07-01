package com.app.ordenaly.model.dtos.orderCart;

import com.app.ordenaly.model.OrderCart;

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
