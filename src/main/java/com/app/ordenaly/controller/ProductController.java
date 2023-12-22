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
  @Autowired
  private ProductMapper productMapper;


  @GetMapping("")
  public List<ProductDto> listAllProducts(){
    List<Product> products = productService.getProducts();
    List<ProductDto> productsDto = productMapper.productsDto(products);
    return productsDto;
  }

  @GetMapping("/{id}")
  public ResponseEntity<ProductDto> getProductById(@PathVariable int id) {
    Product product = productService.getProduct(id);
    ProductDto productDto = productMapper.productToProductDto( product );
    return new ResponseEntity<>(productDto, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<ProductDto> createProduct(
          @RequestBody ProductDto productDto) {
    Product product = productMapper.ProductDtoToProduct( productDto );
    productService.generateProduct( product );
    return new ResponseEntity<ProductDto>(productDto, HttpStatus.CREATED);
  }

  @PutMapping("/{id}")
  public ResponseEntity<ProductDto> updateProduct(
          @PathVariable("id") int productId,
          @RequestBody ProductDto productDto) {
    Product product = productMapper.ProductDtoToProduct(productDto);
    productService.updateProduct(productId, product);
    return new ResponseEntity<>(productDto, HttpStatus.ACCEPTED);
  }

  @DeleteMapping(value = "/{id}")
  public String removeProduct(@PathVariable int id) {
    productService.deleteProduct(id);
    return "Se eliminó el producto: " + id;
  }

}

//TODO: Novedad en el controlador, actualiza recurso pero crea otro nuevo