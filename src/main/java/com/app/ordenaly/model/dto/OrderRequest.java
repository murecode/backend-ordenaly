package com.app.ordenaly.model.dto;

public class OrderRequest {
  private int ticket;
  private int waiter;

  public OrderRequest(int ticket, int waiter) {
    this.ticket = ticket;
    this.waiter = waiter;
  }

  public int getTicket() {
    return ticket;
  }

  public void setTicket(int ticket) {
    this.ticket = ticket;
  }

  public int getWaiter() {
    return waiter;
  }

  public void setWaiter(int waiter) {
    this.waiter = waiter;
  }
}
