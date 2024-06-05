package com.app.ordenaly.controller;

import com.app.ordenaly.model.Product;
import com.app.ordenaly.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping("")
  public List<Product> listAllProducts(){
    return productService.getProducts();
  }

  @PostMapping("")
  public ResponseEntity<Product> createProduct(
          @RequestBody Product product) {
    productService.createProduct( product );
    return new ResponseEntity<Product>(product, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(
          @PathVariable("id") int productId,
          @RequestBody Product product) {
    productService.updateProduct(productId, product);

    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity removeProduct(@PathVariable int id) {
    productService.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }

}

