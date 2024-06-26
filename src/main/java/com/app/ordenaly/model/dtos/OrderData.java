package com.app.ordenaly.model.dtos;

import com.app.ordenaly.model.Order;
//import com.app.ordenaly.model.utils.OrderStatus;
import com.app.ordenaly.model.utils.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public record OrderData(
        int order,
        int ticket,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
        LocalTime time,
        String waiter,
        String table,
        Boolean isOrderComplete,
        PaymentStatus paymentStatus

) {

  public OrderData(Order order) {
    this(
            order.getId(),
            order.getTicket().getId(),
            order.getTicket().getCreatedAt(),
            order.getWaiter().getName(),
            order.getTable(),
            order.getOrderComplete(),
            order.getPaymentStatus()
    );
  }

}
