package com.app.ordenaly.model;

import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;

import java.util.List;

public record OrderData(
        int order,
        int ticket,
        String time,
        String table ,
        String waiter,
        OrderStatus orderStatus,
        PaymentStatus paymentStatus

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
