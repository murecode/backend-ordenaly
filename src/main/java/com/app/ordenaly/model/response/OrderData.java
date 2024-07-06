package com.app.ordenaly.model.response;

import com.app.ordenaly.model.entities.Order;
//import com.app.ordenaly.model.utils.OrderStatus;
import com.app.ordenaly.model.enums.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public record OrderData(
        int order,
        int ticket,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
        LocalTime createdAt,
        String waiter,
        String table,
        int numberOfPeople,
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
            order.getTicket().getNumberOfPeople(),
            order.getOrderComplete(),
            order.getPaymentStatus()
    );
  }
}
