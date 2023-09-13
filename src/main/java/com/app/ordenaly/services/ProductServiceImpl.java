package com.app.ordenaly.services;

import com.app.ordenaly.models.Product;
import com.app.ordenaly.repositories.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements IProductService {
  private final ProductRepository productRepository;
  public ProductServiceImpl(ProductRepository productRepository) {
    this.productRepository = productRepository;
  }

  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  public void removeProduct(Integer id) {
    productRepository.deleteById(id);
  }

  public List<Product> listAllProducts() {
    return productRepository.findAll();
  }
}
