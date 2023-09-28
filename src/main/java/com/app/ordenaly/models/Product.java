
package com.app.ordenaly.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCTS")
public class Product {
  @Transient
  private String type = "product";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PRODUCT_ID")
  private Integer id;

  @Column(name = "_DESCRIPTION", length = 45)
  private String description;

  @Column(name = "PRICE")
  private Double price;

  @Column(name = "IN_STOCK")
  private Boolean inStock;


  public String getType() {
    return type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
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
