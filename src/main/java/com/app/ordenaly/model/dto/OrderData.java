package com.app.ordenaly.model.dto;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.utils.OrderStatus;
import com.app.ordenaly.model.utils.PaymentStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public record OrderData(
        int order,
        int ticket,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
        LocalTime time,
        String waiter,
        String table,
        Boolean isAttended,
        PaymentStatus paymentStatus

) {

  public OrderData(Order order) {
    this(
            order.getId(),
            order.getTicket().getId(),
            order.getTicket().getTime(),
            order.getWaiter().getName(),
            order.getTable(),
            order.getAttended(),
            order.getPaymentStatus()
    );
  }

}
