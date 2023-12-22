package com.app.ordenaly.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class ProductDto {
  private String product_id;
  private String product_name;
  private String description;
  private Double price;
  private Boolean in_stock;

  public ProductDto() {}

//  public ProductDto(int product_id, String product_name, String description, Double price, Boolean in_stock) {
//    this.product_id = product_id;
//    this.product_name = product_name;
//    this.description = description;
//    this.price = price;
//    this.in_stock = in_stock;
//  }

  public String getProduct_id() {
    return product_id;
  }

  public void setProduct_id(String product_id) {
    this.product_id = product_id;
  }

  public String getProduct_name() {
    return product_name;
  }

  public void setProduct_name(String product_name) {
    this.product_name = product_name;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Double getPrice() {
    return price;
  }

  public void setPrice(Double price) {
    this.price = price;
  }

  public Boolean getIn_stock() {
    return in_stock;
  }

  public void setIn_stock(Boolean in_stock) {
    this.in_stock = in_stock;
  }
}
