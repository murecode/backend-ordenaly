package com.app.ordenaly.controllers;

import com.app.ordenaly.models.Product;
import com.app.ordenaly.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping(value = "/remove/{id}")
  public void removeProduct(@PathVariable("id") Integer id) {
    productService.deleteProduct(id);
  }

  @GetMapping(value = "/list")
  public List<Product> listAllProducts(){
    return productService.getAllProducts();
  }

}
