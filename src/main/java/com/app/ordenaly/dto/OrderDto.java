package com.app.ordenaly.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class OrderDto {
  private int order_id;
  private int related_ticket;
  private int related_table;
  private String waiter;
  private String order_status;
  private String payment_status;
  private List<ItemDto> item_list;
  private String order_comment;

  public OrderDto() {};

  public int getOrder_id() {
    return order_id;
  }

  public void setOrder_id(int order_id) {
    this.order_id = order_id;
  }

  public int getRelated_ticket() {
    return related_ticket;
  }

  public void setRelated_ticket(int related_ticket) {
    this.related_ticket = related_ticket;
  }

  public int getRelated_table() {
    return related_table;
  }

  public void setRelated_table(int related_table) {
    this.related_table = related_table;
  }

  public String getWaiter() {
    return waiter;
  }

  public void setWaiter(String waiter) {
    this.waiter = waiter;
  }

  public String getOrder_status() {
    return order_status;
  }

  public void setOrder_status(String order_status) {
    this.order_status = order_status;
  }

  public String getPayment_status() {
    return payment_status;
  }

  public void setPayment_status(String payment_status) {
    this.payment_status = payment_status;
  }

  public List<ItemDto> getItem_list() {
    return item_list;
  }

  public void setItem_list(List<ItemDto> item_list) {
    this.item_list = item_list;
  }

  public String getOrder_comment() {
    return order_comment;
  }

  public void setOrder_comment(String order_comment) {
    this.order_comment = order_comment;
  }

}
