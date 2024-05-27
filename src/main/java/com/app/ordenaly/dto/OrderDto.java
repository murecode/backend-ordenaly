package com.app.ordenaly.dto;

import com.app.ordenaly.models.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class OrderDto {
  private String id;
  private int ticket;
  private String table;
  private String waiter;
  private String orderStatus;
  private String paymentStatus;
  private String orderComment;
  private List<Item> itemList;

  public OrderDto() {}

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public int getTicket() {
    return ticket;
  }

  public void setTicket(int ticket) {
    this.ticket = ticket;
  }

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  public String getWaiter() {
    return waiter;
  }

  public void setWaiter(String waiter) {
    this.waiter = waiter;
  }

  public String getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(String orderStatus) {
    this.orderStatus = orderStatus;
  }

  public String getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(String paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public String getOrderComment() {
    return orderComment;
  }

  public void setOrderComment(String orderComment) {
    this.orderComment = orderComment;
  }

  public List<Item> getItemList() {
    return itemList;
  }

  public void setItemList(List<Item> itemList) {
    this.itemList = itemList;
  }
}
