package com.app.ordenaly.presentation.response;

import com.app.ordenaly.model.entity.Order;
//import com.app.ordenaly.model.utils.OrderStatus;
import com.app.ordenaly.model.enums.OrderStatus;
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
        OrderStatus orderStatus,
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
            order.getOrderStatus(),
            order.getPaymentStatus()
    );
  }
}
