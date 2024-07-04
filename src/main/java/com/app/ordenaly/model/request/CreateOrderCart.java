package com.app.ordenaly.model.request;

public class CreateOrderCart {
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
