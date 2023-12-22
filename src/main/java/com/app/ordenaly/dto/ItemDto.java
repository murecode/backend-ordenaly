package com.app.ordenaly.dto;

public class ItemDto {
  private String item_id;
  private String product_name;
  private int price;
  private int quantity;

  public ItemDto() {};

//  public ItemDto(int item_id, String product_name, int precio, int quantity) {
//    this.item_id = item_id;
//    this.product_name = product_name;
//    this.price = price;
//    this.quantity = quantity;
//  }

  public String getItem_id() {
    return item_id;
  }

  public void setItem_id(String item_id) {
    this.item_id = item_id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
