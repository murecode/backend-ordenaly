package com.app.ordenaly.model.dtos.product;

import jakarta.validation.constraints.NotBlank;

public class ProductCreateData {
  @NotBlank
  private String title;
  @NotBlank
  private String description;
  @NotBlank
  private String imageUrl;
  @NotBlank
  private int price;
  @NotBlank
  private Boolean inStock;

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
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
}
