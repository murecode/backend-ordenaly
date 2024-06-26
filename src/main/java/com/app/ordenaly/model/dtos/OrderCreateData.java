package com.app.ordenaly.model.dtos;

public class OrderCreateData {
  private int ticket;
  private int waiter;
  private String table;

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

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }
}
