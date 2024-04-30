package com.app.ordenaly.dto;

import com.app.ordenaly.models.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

public class OrderDto {
  private String order_id;
  private String related_ticket;
  private String related_table;
  private String related_waiter;
  private String order_status;
  private String payment_status;
  private String order_comment;
  private List<Item> item_list;

  public OrderDto() {}

  public String getOrder_id() {
    return order_id;
  }

  public void setOrder_id(String order_id) {
    this.order_id = order_id;
  }

  public String getRelated_ticket() {
    return related_ticket;
  }

  public void setRelated_ticket(String related_ticket) {
    this.related_ticket = related_ticket;
  }

  public String getRelated_table() {
    return related_table;
  }

  public void setRelated_table(String related_table) {
    this.related_table = related_table;
  }

  public String getRelated_waiter() {
    return related_waiter;
  }

  public void setRelated_waiter(String related_waiter) {
    this.related_waiter = related_waiter;
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

  public String getOrder_comment() {
    return order_comment;
  }

  public void setOrder_comment(String order_comment) {
    this.order_comment = order_comment;
  }

  public List<Item> getItemList() {
    return item_list;
  }

  public void setItemList(List<Item> itemList) {
    this.item_list = itemList;
  }
}
