package com.app.ordenaly.model.dto;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.security.model.User;

public record OrderRequest(int ticket, int waiter, String table) {

  public OrderRequest(Order order) {
    this(
            order.getTicket().getId(),
            order.getWaiter().getId(),
            order.getTable()
    );
  }

}
