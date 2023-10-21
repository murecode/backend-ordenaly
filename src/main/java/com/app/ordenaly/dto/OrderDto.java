package com.app.ordenaly.dto;

import com.app.ordenaly.model.OrderStatus;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.model.User;

import java.io.Serializable;
import java.time.LocalTime;

public class OrderDto {
  private int orderId;
  private int ticket;
  private String waiter;
  private String status;

  public OrderDto() {};

  public OrderDto(int orderId, int ticket, String waiter, String status) {
    this.orderId = orderId;
    this.ticket = ticket;
    this.waiter = waiter;
    this.status = status;
  }

  public int getOrderId() {
    return orderId;
  }

  public void setOrderId(int orderId) {
    this.orderId = orderId;
  }

  public int getTicket() {
    return ticket;
  }

  public void setTicket(int ticket) {
    this.ticket = ticket;
  }

  public String getWaiter() {
    return waiter;
  }

  public void setWaiter(String waiter) {
    this.waiter = waiter;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
