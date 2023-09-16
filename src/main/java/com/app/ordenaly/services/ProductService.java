package com.app.ordenaly.services;

import com.app.ordenaly.models.Product;
import com.app.ordenaly.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepo;

  public Product saveProduct(Product product) {
    return productRepo.save(product);
  }

  public void deleteProduct(Integer id) {
    productRepo.deleteById(id);
  }

  public List<Product> getAllProducts() {
    return productRepo.findAll();
  }

}
