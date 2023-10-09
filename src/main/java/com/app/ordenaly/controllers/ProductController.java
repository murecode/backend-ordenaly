package com.app.ordenaly.controllers;

import com.app.ordenaly.models.Product;
import com.app.ordenaly.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
  public String newProduct(@RequestBody Product product) {
    productService.saveProduct(product);
    return "Nuevo producto creado: " + product.getDescription();
  }

  @GetMapping(value = "/list")
  public List<Product> listAllProducts(){
    return productService.getAllProducts();
  }

  @DeleteMapping(value = "/remove/{id}")
  public String removeProduct(@PathVariable Integer id) {
    productService.deleteProduct(id);
    return "Se eliminó el producto: " + id;
  }



}
