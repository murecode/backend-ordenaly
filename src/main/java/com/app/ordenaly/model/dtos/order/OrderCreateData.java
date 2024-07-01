package com.app.ordenaly.model.dtos.order;

import com.app.ordenaly.infra.security.model.User;
import com.app.ordenaly.model.Ticket;
import jakarta.validation.constraints.NotBlank;

public class OrderCreateData {
  @NotBlank
  private Ticket ticket;
  @NotBlank
  private User waiter;
  @NotBlank
  private String table;

  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public User getWaiter() {
    return waiter;
  }

  public void setWaiter(User waiter) {
    this.waiter = waiter;
  }

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }
}
