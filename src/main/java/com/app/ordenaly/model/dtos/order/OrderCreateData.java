package com.app.ordenaly.model.dtos.order;

import com.app.ordenaly.infra.security.model.User;
import com.app.ordenaly.model.Ticket;
import jakarta.validation.constraints.NotBlank;

public class OrderCreateData {
  @NotBlank
  private Integer ticket;
  @NotBlank
  private Integer waiter;
  @NotBlank
  private String table;

  public OrderCreateData() {}

  public OrderCreateData(Integer ticket, Integer waiter, String table) {
    this.ticket = ticket;
    this.waiter = waiter;
    this.table = table;
  }

  public Integer getTicket() {
    return ticket;
  }

  public void setTicket(Integer ticket) {
    this.ticket = ticket;
  }

  public Integer getWaiter() {
    return waiter;
  }

  public void setWaiter(Integer waiter) {
    this.waiter = waiter;
  }

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }
}
