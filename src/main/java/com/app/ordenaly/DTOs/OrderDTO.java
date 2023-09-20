package com.app.ordenaly.DTOs;

import java.io.Serializable;

public class OrderDTO implements Serializable {
  private String waiterName;
  private Integer ticketNumber;
  public OrderDTO() {};
  public OrderDTO(String waiterName, Integer ticketNumber) {
    this.waiterName = waiterName;
    this.ticketNumber = ticketNumber;
  }

  public String getWaiterName(String name) {
    return waiterName;
  }

  public void setWaiterName(String waiterName) {
    this.waiterName = waiterName;
  }

  public Integer getTicketNumber(Integer id) {
    return ticketNumber;
  }

  public void setTicketNumber(Integer ticketNumber) {
    this.ticketNumber = ticketNumber;
  }

}
