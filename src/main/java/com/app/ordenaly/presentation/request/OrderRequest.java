package com.app.ordenaly.presentation.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class OrderRequest {
  @NotNull
  private Integer ticket;
  @NotNull
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
