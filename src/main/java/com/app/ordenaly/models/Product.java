
package com.app.ordenaly.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "PRODUCT")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PRODUCT_ID")
  private int id;
  @NotNull
  @Column(name = "PRODUCT_NAME", length = 45, unique = true)
  private String productName;
  @Column(name = "\"DESCRIPTION\"", length = 90)
  private String description;
  @NotNull
  @Column(name = "PRICE")
  @DecimalMin(value = "0.01")
  private Double price;
  @NotNull
  @Column(name = "IN_STOCK")
  private Boolean inStock;

  public Product() {}

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
