package com.app.ordenaly.model.response;

import com.app.ordenaly.model.entities.Product;

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
