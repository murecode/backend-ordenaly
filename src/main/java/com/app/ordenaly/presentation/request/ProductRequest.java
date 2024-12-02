package com.app.ordenaly.presentation.request;

import com.app.ordenaly.model.entity.ProductCategory;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ProductRequest {

  @NotBlank
  private Integer category;

  @NotBlank
//  @Size(max = 30)
  private String title;

  @NotBlank
//  @Size(max = 90)
  private String description;

  @NotBlank
  private String imageUrl;

  @NotBlank
  private Integer price;

  @NotBlank
  private Boolean inStock;

  public ProductRequest(
          Integer productCategory,
          String title,
          String description,
          String imageUrl,
          Integer price,
          Boolean inStock) {
  }

  public Integer getCategory() {
    return category;
  }

  public void setCategory(Integer category) {
    this.category = category;
  }

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

  public Integer getPrice() {
    return price;
  }

  public void setPrice(Integer price) {
    this.price = price;
  }

  public Boolean getInStock() {
    return inStock;
  }

  public void setInStock(Boolean inStock) {
    this.inStock = inStock;
  }
}
