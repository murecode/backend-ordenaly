package com.app.ordenaly.presentation.response;

import com.app.ordenaly.model.entity.OrderItem;

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
