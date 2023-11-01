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

  public Product generateProduct(Product product){
    Product newProduct = new Product();
    newProduct.setProductName(product.getProductName());
    newProduct.setDescription(product.getDescription());
    newProduct.setPrice(product.getPrice());
    newProduct.setInStock(product.getInStock());
    return productRepository.save(newProduct);
  }

  public void deleteProduct(Integer id) {
    productRepository.deleteById(id);
  }

  public Product getProduct(Integer id) { return productRepository.findById(id).orElse(null); }

  public Product updateProduct(int productId, Product product) {
    Product id = productRepository.findById(productId).get();

    product.setId(id.getId());

    return productRepository.save(product);

  }

  public List<ProductDto> getProducts() {
    List<Product> products = productRepository.findAll();
    return products.stream()
            .map(productMapper::productToProductDto)
            .collect(Collectors.toList());
  }



}
