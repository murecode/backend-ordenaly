package com.app.ordenaly.controllers;

import com.app.ordenaly.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/product")
public class ProductController {
  @Autowired
  private IProductService productService;

  @GetMapping(value = "/remove/{id}")
  public void removeProduct(@PathVariable("id") Integer id) {
    productService.removeProduct(id);

  }

}
