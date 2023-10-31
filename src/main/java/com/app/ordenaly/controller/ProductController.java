package com.app.ordenaly.controller;

import com.app.ordenaly.dto.ProductDto;
import com.app.ordenaly.dto.mapper.ProductMapper;
import com.app.ordenaly.model.Product;
import com.app.ordenaly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Product createdProduct = productService.generateProduct(product);
    return new ResponseEntity<Product>(createdProduct, HttpStatus.OK);
  }

  @GetMapping(value = "/list")
  public List<ProductDto> listAllProducts(){
    return productService.getProducts();
  }

  @DeleteMapping(value = "/remove/{id}")
  public String removeProduct(@PathVariable Integer id) {
    productService.deleteProduct(id);
    return "Se eliminó el producto: " + id;
  }

  @PutMapping(value = "/edit/{id}")
  public Product updateProduct(@PathVariable Integer id, @RequestBody Product product) {
    product.setId(id);
    return productService.updateProduct(product);
  }



}
