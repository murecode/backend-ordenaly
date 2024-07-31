package com.app.ordenaly.model.response;

import com.app.ordenaly.model.entities.OrderItem;

public record OrderItemData(
        int id,
        String product,
        int quantity,
        int subtotal
) {

  public OrderItemData(OrderItem orderItem) {
    this(
            orderItem.getId(),
            orderItem.getProduct().getTitle(),
            orderItem.getQuantity(),
            orderItem.calculateSubtotal()
    );
  }

}
