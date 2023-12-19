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
@RequestMapping(value = "/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @PostMapping("")
  public ResponseEntity<Product> createProduct(@RequestBody Product product) {
    Product createdProduct = productService.generateProduct(product);
    return new ResponseEntity<Product>(createdProduct, HttpStatus.CREATED);
  }

  @GetMapping("")
  public List<ProductDto> listAllProducts(){
    return productService.getProducts();
  }

  @GetMapping("/{id}")
  public Product getProductById(@PathVariable int id) {
    return productService.getProduct(id);
  }

  @DeleteMapping(value = "/{id}")
  public String removeProduct(@PathVariable int id) {
    productService.deleteProduct(id);
    return "Se eliminó el producto: " + id;
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateProduct(
          @PathVariable("id") int productId,
          @RequestBody Product productBody) {
    productService.updateProduct(productId, productBody);
    return new ResponseEntity<>("Producto actualizado", HttpStatus.ACCEPTED);
  }

}

//TODO: Novedad en el controlador, actualiza recurso pero crea otro nuevo