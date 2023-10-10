package com.app.ordenaly.services;

import com.app.ordenaly.models.Product;
import com.app.ordenaly.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.crypto.spec.OAEPParameterSpec;
import java.util.List;
import java.util.Optional;

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

  public Product findProduct(Integer id) { return productRepo.findById(id).orElse(null); }

  public Product updateProduct(Product product) {
    return productRepo.save(product);
  }



}
