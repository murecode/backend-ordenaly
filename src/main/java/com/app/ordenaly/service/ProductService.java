package com.app.ordenaly.service;

import com.app.ordenaly.dto.ProductDto;
import com.app.ordenaly.dto.mapper.ProductMapper;
import com.app.ordenaly.model.Product;
import com.app.ordenaly.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;
  @Autowired
  ProductMapper productMapper;

  public Product saveProduct(Product product) {
    return productRepository.save(product);
  }

  public void deleteProduct(Integer id) {
    productRepository.deleteById(id);
  }

  public List<Product> getAllProducts() {
    return productRepository.findAll();
  }

  public Product getProduct(Integer id) { return productRepository.findById(id).orElse(null); }

  public Product updateProduct(Product product) {
    return productRepository.save(product);
  }

  public List<ProductDto> getProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream()
            .map(productMapper::productToProductDto)
            .collect(Collectors.toList());
  }



}
