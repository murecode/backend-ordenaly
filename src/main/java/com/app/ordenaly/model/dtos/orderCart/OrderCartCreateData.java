package com.app.ordenaly.model.dtos.orderCart;

public class OrderCartCreateData {
  private Integer product;
  private int quantity;

  public Integer getProduct() {
    return product;
  }

  public void setProduct(Integer product) {
    this.product = product;
  }

  public int getQuantity() {
    return quantity;
  }

  public void setQuantity(int quantity) {
    this.quantity = quantity;
  }
}
