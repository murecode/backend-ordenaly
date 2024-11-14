
package com.app.ordenaly.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;

@Entity
@Table(name = "products")
public class Product {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @Column(unique = true)
  private String title;
  @Column(name = "\"description\"")
  private String description;
  @ManyToOne
  @JoinColumn(name = "category")
  private ProductCategory category;
  @Column
  private String imageUrl;
  @DecimalMin(value = "0")
  private int price;
  private Boolean inStock;

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public ProductCategory getCategory() {
    return category;
  }

  public void setCategory(ProductCategory category) {
    this.category = category;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public String getImageUrl() {
    return imageUrl;
  }

  public void setImageUrl(String imageUrl) {
    this.imageUrl = imageUrl;
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
            "PRODUCT: "      + title + "\n" +
            "CATEGORY:"      + category + "\n" +
            "DESCRIPTION: "  + description + "\n" +
            "PRICE: "        + price       + "\n" +
            "INSTOCK: "      + inStock     + "\n" ;
  }

}
