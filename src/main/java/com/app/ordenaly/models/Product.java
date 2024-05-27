
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
  private int price;
  @NotNull
  @Column(name = "IN_STOCK")
  private Boolean inStock;

  public Product() {}

  public Product(int id, String productName, String description, int price, boolean inStock) {
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

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Boolean getInStock() {
    return inStock;
  }

  public void setInStock(Boolean inStock) {
    this.inStock = inStock;
  }

  @Override
  public String toString() {
    return  "ID: "           + id          + "\n" +
            "PRODUCT: "      + productName + "\n" +
            "DESCRIPTION: "  + description + "\n" +
            "PRICE: "        + price       + "\n" +
            "INSTOCK: "      + inStock     + "\n" ;
  }
}
