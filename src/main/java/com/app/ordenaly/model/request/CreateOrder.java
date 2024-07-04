package com.app.ordenaly.model.request;

import jakarta.validation.constraints.NotBlank;

public class CreateOrder {
  private Integer ticket;
  private Integer waiter;
  @NotBlank
  private String table;

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
