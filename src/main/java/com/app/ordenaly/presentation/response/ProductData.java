package com.app.ordenaly.presentation.response;

import com.app.ordenaly.model.entity.Product;
import com.app.ordenaly.model.entity.ProductCategory;

public record ProductData(
        int id,
        Integer category,
        String title,
        String description,
        String imageUrl,
        int price,
        Boolean inStock

) {
  public ProductData(Product product) {
    this(
            product.getId(),
            product.getCategory().getId(),
            product.getTitle(),
            product.getDescription(),
            product.getImageUrl(),
            product.getPrice(),
            product.getInStock()
    );
  }
}
