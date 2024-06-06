package com.app.ordenaly.model.dto;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.utils.OrderStatus;
import com.app.ordenaly.model.utils.PaymentStatus;

public record OrderData(
        int orden,
        int turno,
        String hora,
        String mesa,
        String mesero,
        OrderStatus estadoDeOrden,
        PaymentStatus estadoDePago

) {

  public OrderData(Order order) {
    this(
            order.getId(),
            order.getTicket().getId(),
            order.getTicket().getTime().toString(),
            order.getTable(),
            order.getWaiter().getName(),
            order.getOrderStatus(),
            order.getPaymentStatus()
    );
  }

}
