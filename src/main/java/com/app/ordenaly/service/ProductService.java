package com.app.ordenaly.service;

import com.app.ordenaly.model.Product;
import com.app.ordenaly.repository.ProductRepository;
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

  public Product getProduct(Integer id) { return productRepo.findById(id).orElse(null); }

  public Product updateProduct(Product product) {
    return productRepo.save(product);
  }



}
