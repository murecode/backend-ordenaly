package com.app.ordenaly.model.dtos.product;

import com.app.ordenaly.model.Product;

public record ProductData(
        int id,
        String title,
        String description,
        String imageUrl,
        int price,
        Boolean inStock

) {
  public ProductData(Product product) {
    this(
            product.getId(),
            product.getTitle(),
            product.getDescription(),
            product.getImageUrl(),
            product.getPrice(),
            product.getInStock()
    );
  }
}
