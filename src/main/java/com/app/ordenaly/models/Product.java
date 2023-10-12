
package com.app.ordenaly.models;

import jakarta.persistence.*;

@Entity
@Table(name = "PRODUCT")
public class Product {
  @Transient
  private String type = "product";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "PRODUCT_ID")
  private Integer id;

  @Column(name = "PRODUCT_NAME", length = 45)
  private String productName;

  @Column(name = "DESCRIPTION_", length = 90)
  private String description;

  @Column(name = "PRICE")
  private Double price;

  @Column(name = "IN_STOCK")
  private Boolean inStock;

  public Product() {};

  public Product(String description, Double price, Boolean inStock) {
    this.description = description;
    this.price = price;
    this.inStock = inStock;
  }


  public String getType() {
    return type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
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
