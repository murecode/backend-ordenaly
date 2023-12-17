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

  public Product generateProduct(Product productBody) {
    Product product = new Product();
    product.setProductName(productBody.getProductName());
    product.setDescription(productBody.getDescription());
    product.setPrice(productBody.getPrice());
    product.setInStock(productBody.getInStock());
    return productRepository.save(product);
  }

  public List<ProductDto> getProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream()
            .map(productMapper::productToProductDto)
            .collect(Collectors.toList());
  }

  public Product getProduct(int id) {
    return productRepository.findById(id).get();
  }

  public Product updateProduct(int productId, Product productBoby) {
    Product product = productRepository.findById(productId).orElse(null);

//    if (product != null) return null;

    product.setProductName(productBoby.getProductName());
    product.setDescription(productBoby.getDescription());
    product.setPrice(productBoby.getPrice());
    product.setInStock(productBoby.getInStock());
    return productRepository.save(product);

  }

  public void deleteProduct(int id) {
    productRepository.deleteById(id);
  }


}
