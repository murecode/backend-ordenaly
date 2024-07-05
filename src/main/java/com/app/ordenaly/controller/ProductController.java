package com.app.ordenaly.controller;

import com.app.ordenaly.infra.exceptions.ResourceNotFoundExeption;
import com.app.ordenaly.model.request.CreateProduct;
import com.app.ordenaly.model.response.ProductData;
import com.app.ordenaly.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products")
public class ProductController {
  @Autowired
  private ProductService productService;

  @GetMapping
  public ResponseEntity<Page<ProductData>> listAllProducts(Pageable pageable) {
    Page<ProductData> products = productService.getProducts(pageable);
    return ResponseEntity.ok(products);
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductData> getProduct(
          @PathVariable("id") Integer id ) {
    ProductData product = productService.getProduct(id);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @PostMapping
  public ResponseEntity<ProductData> createProduct(
          @RequestBody @Valid CreateProduct productData) {
    ProductData product = productService.createProduct(productData);
    return new ResponseEntity<>(product, HttpStatus.CREATED);
  }

  @PatchMapping("/{id}")
  public ResponseEntity<CreateProduct> updateProduct(
          @PathVariable("id") int productId,
          @RequestBody @Valid CreateProduct product) {
    productService.updateProduct(productId, product);

    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity removeProduct(@PathVariable int id) {
    productService.deleteProduct(id);
    return ResponseEntity.noContent().build();
  }

}

