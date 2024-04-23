package com.app.ordenaly.controllers;

import com.app.ordenaly.models.Product;
import com.app.ordenaly.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
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
//    Product product = productMapper.ProductDtoToProduct( productDto );
    productService.createProduct( product );

    /*TODO: "manejar casos de error y validar los datos recibidos"*/

    return new ResponseEntity<Product>(product, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Product> updateProduct(
          @PathVariable("id") int productId,
          @RequestBody Product product) {
//    Product product = productMapper.ProductDtoToProduct(productDto);
    productService.updateProduct(productId, product);

  //TODO: "manejar casos de error y validar los datos recibidos"

    return new ResponseEntity<>(product, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public String removeProduct(@PathVariable int id) {
    productService.deleteProduct(id);
    return "Producto " + id + " eliminado";
  }

}

