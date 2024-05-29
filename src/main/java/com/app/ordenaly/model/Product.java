
package com.app.ordenaly.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(unique = true) @NotNull
  private String productName;
  @Column(name = "\"DESCRIPTION\"")
  private String description;
  @DecimalMin(value = "0") @NotNull
  private int price;
  @NotNull
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
