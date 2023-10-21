package com.app.ordenaly.dto;

public class ProductDto {
  private int id;
  private String productName;
  private String description;
  private Double price;
  private Boolean inStock;

  public ProductDto() {};
  public ProductDto(int id, String productName, String description, Double price, Boolean inStock) {
    this.id = id;
    this.productName = productName;
    this.description = description;
    this.price = price;
    this.inStock = inStock;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProductName() {
    return productName;
  }

  public void setProductName(String productName) {
    this.productName = productName;
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

  public Boolean getInStock() {
    return inStock;
  }

  public void setInStock(Boolean inStock) {
    this.inStock = inStock;
  }

}
