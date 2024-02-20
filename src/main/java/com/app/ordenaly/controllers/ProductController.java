package com.app.ordenaly.controllers;

import com.app.ordenaly.dto.ProductDto;
import com.app.ordenaly.dto.mapper.ProductMapper;
import com.app.ordenaly.models.Product;
import com.app.ordenaly.services.ProductService;
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
  @Autowired
  private ProductMapper productMapper;


  @GetMapping("")
  public List<ProductDto> listAllProducts(){
    List<Product> products = productService.getProducts();
    List<ProductDto> productsDto = productMapper.productsDto(products);
    return productsDto;
  }

  @PostMapping("")
  public ResponseEntity<ProductDto> createProduct(
          @RequestBody ProductDto productDto) {
    Product product = productMapper.ProductDtoToProduct( productDto );
    productService.createProduct( product );
    // TODO: "manejar casos de error y validar los datos recibidos"
    return new ResponseEntity<ProductDto>(productDto, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductDto> updateProduct(
          @PathVariable("id") int productId,
          @RequestBody ProductDto productDto) {
    Product product = productMapper.ProductDtoToProduct(productDto);
    productService.updateProduct(productId, product);
  // TODO: "manejar casos de error y validar los datos recibidos"
    return new ResponseEntity<>(productDto, HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public String removeProduct(@PathVariable int id) {
    productService.deleteProduct(id);
    return "Producto " + id + " eliminado";
  }

}

