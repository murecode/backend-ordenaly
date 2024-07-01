package com.app.ordenaly.service;

import com.app.ordenaly.model.Product;
import com.app.ordenaly.infra.repository.ProductRepository;
import com.app.ordenaly.model.dtos.product.ProductCreateData;
import com.app.ordenaly.model.dtos.product.ProductData;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {
  @Autowired
  ProductRepository productRepo;

  public Page<ProductData> getProducts(Pageable pageable) {
    return productRepo.findAll(pageable).map(ProductData::new);
  }

  public ProductData createProduct(ProductCreateData productBody) {

    Product product = new Product();
    product.setTitle(productBody.getTitle());
    product.setDescription(productBody.getDescription());
    product.setImageUrl(productBody.getImageUrl());
    product.setPrice(productBody.getPrice());
    product.setInStock(productBody.getInStock());

    Product p = productRepo.save(product);

    return new ProductData(
            p.getId(),
            p.getTitle(),
            p.getDescription(),
            p.getImageUrl(),
            p.getPrice(),
            p.getInStock()
    );
  }

  public Product getProduct(int id) {
    return productRepo.findById(id).get();
  }

  public void updateProduct(int productId, Product productBoby) {
    Product product = productRepo.findById(productId).orElse(null);

    if( product != null ) {
      product.setTitle(productBoby.getTitle());
      product.setDescription(productBoby.getDescription());
      product.setPrice(productBoby.getPrice());
      product.setInStock(productBoby.getInStock());

      productRepo.save(product);

    } else {
      throw new EntityNotFoundException("No se encontró el producto con ID: " + productId);
    }
  }

  public void deleteProduct(int id) {
    productRepo.deleteById(id);
  }

}
