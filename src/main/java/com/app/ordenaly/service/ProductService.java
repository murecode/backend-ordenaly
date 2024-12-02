package com.app.ordenaly.service;

import com.app.ordenaly.model.entity.ProductCategory;
import com.app.ordenaly.presentation.advice.exception.product_exception.ProductInvalidPriceException;
import com.app.ordenaly.repository.ProductCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import com.app.ordenaly.presentation.advice.exception.product_exception.ProductAlreadyExistException;
import com.app.ordenaly.presentation.advice.exception.product_exception.ProductNotFoundException;
import com.app.ordenaly.model.entity.Product;
import com.app.ordenaly.repository.ProductRepository;
import com.app.ordenaly.presentation.request.ProductRequest;
import com.app.ordenaly.presentation.response.ProductData;

@Service
public class ProductService {

  @Autowired
  ProductRepository productRepo;

  @Autowired
  ProductCategoryRepository productCategoryRepo;

  public Page<ProductData> getProducts(Pageable pageable) {
    return productRepo.findAll(pageable).map(ProductData::new);
  }

  public ProductData createProduct(ProductRequest productBody) {

    String productTitle = productBody.getTitle();
    Integer productPrice = productBody.getPrice();

    Optional<Product> productOptional = productRepo.findByTitle(productTitle);
    Optional<ProductCategory> productCategoryOptional = productCategoryRepo.findById(productBody.getCategory());

    if (productOptional.isPresent()) {
      throw new ProductAlreadyExistException("El producto ya existe, intenta de nuevo");
    }

    if (productPrice <= 0) {
      throw new ProductInvalidPriceException("Ingresa un valor valido, superior a cero");
    }

    Product product = new Product();
    product.setCategory(productCategoryOptional.get());
    product.setTitle(productBody.getTitle());
    product.setDescription(productBody.getDescription());
    product.setImageUrl(productBody.getImageUrl());
    product.setPrice(productBody.getPrice());
    product.setInStock(productBody.getInStock());

    Product p = productRepo.save(product);

    return new ProductData(
            p.getId(),
            p.getCategory().getId(),
            p.getTitle(),
            p.getDescription(),
            p.getImageUrl(),
            p.getPrice(),
            p.getInStock()
    );
  }

  public ProductData getProduct(int id) {
    Optional<Product> product = productRepo.findById(id);

    return product.map(p -> new ProductData(
            p.getId(),
            p.getCategory().getId(),
            p.getTitle(),
            p.getDescription(),
            p.getImageUrl(),
            p.getPrice(),
            p.getInStock()
    )).orElseThrow(() -> new ProductNotFoundException("El producto" + product.get().getId() + "no fue encontrado"));
  }

//  @Transactional
  public ProductData updateProduct(int productId, ProductRequest productBoby) {

    Optional<Product> productOptional = productRepo.findById(productId);
    Optional<ProductCategory> categoryOptional = productCategoryRepo.findById(productBoby.getCategory());

    if (categoryOptional.isPresent()) {
      productOptional.get().setCategory(categoryOptional.get());
    }
    if (productBoby.getDescription() != null) {
      productOptional.get().setTitle(productBoby.getTitle());
    }
    if (productBoby.getDescription() != null) {
      productOptional.get().setDescription(productBoby.getDescription());
    }
    if (productBoby.getImageUrl() != null) {
      productOptional.get().setImageUrl(productBoby.getImageUrl());
    }
    if (productBoby.getPrice() != null) {
      productOptional.get().setPrice(productBoby.getPrice());
    }
    if (productBoby.getInStock() != null) {
      productOptional.get().setInStock(productBoby.getInStock());
    }

    Product p = productRepo.save(productOptional.get());

    return new ProductData(
            p.getId(),
            p.getCategory().getId(),
            p.getTitle(),
            p.getDescription(),
            p.getImageUrl(),
            p.getPrice(),
            p.getInStock()
    );
  }

  public void deleteProduct(int id) {
    productRepo.deleteById(id);
  }

}
