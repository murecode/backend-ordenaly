package com.app.ordenaly.services;

import com.app.ordenaly.dto.mapper.ProductMapper;
import com.app.ordenaly.models.Product;
import com.app.ordenaly.repositories.ProductRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepository;
  @Autowired
  ProductMapper productMapper;

  public Product createProduct(Product productBody) {
    Product product = new Product();
    product.setProductName(productBody.getProductName());
    product.setDescription(productBody.getDescription());
    product.setPrice(productBody.getPrice());
    product.setInStock(productBody.getInStock());
    return productRepository.save(product);
  }

  public List<Product> getProducts() {
    List<Product> products = productRepository.findAll();
    return products;
  }

  public Product getProduct(int id) {
    return productRepository.findById(id).get();
  }

  public Product updateProduct(int productId, Product productBoby) {
    Product product = productRepository.findById(productId).orElse(null);

    if( product != null ) {
      product.setProductName(productBoby.getProductName());
      product.setDescription(productBoby.getDescription());
      product.setPrice(productBoby.getPrice());
      product.setInStock(productBoby.getInStock());
      return productRepository.save(product);
    } else {
      throw new EntityNotFoundException("No se encontró el producto con ID: " + productId);
    }
  }

  public void deleteProduct(int id) {
    productRepository.deleteById(id);
  }



}
