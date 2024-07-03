package com.app.ordenaly.model.dtos.order;

import com.app.ordenaly.infra.security.model.User;
import com.app.ordenaly.model.Ticket;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.io.Serializable;

public class OrderCreateData {
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
