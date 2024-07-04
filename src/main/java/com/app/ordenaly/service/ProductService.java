package com.app.ordenaly.service;

import com.app.ordenaly.model.entities.Product;
import com.app.ordenaly.infra.repository.ProductRepository;
import com.app.ordenaly.model.request.CreateProduct;
import com.app.ordenaly.model.response.ProductData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {
  @Autowired
  ProductRepository productRepo;

  public Page<ProductData> getProducts(Pageable pageable) {
    return productRepo.findAll(pageable).map(ProductData::new);
  }

  public ProductData createProduct(CreateProduct productBody) {

    Product product = new Product();
    product.setTitle(productBody.getTitle());
    product.setDescription(productBody.getDescription());
    product.setImageUrl(productBody.getImageUrl());
    product.setPrice(productBody.getPrice());
    product.setInStock(productBody.getInStock());

    Product p = productRepo.save(product);

    return new ProductData(
            p.getId(),
            p.getTitle(),
            p.getDescription(),
            p.getImageUrl(),
            p.getPrice(),
            p.getInStock()
    );
  }

  public Product getProduct(int id) {
    return productRepo.findById(id).get();
  }

  @Transactional
  public CreateProduct updateProduct(int productId, CreateProduct productBoby) {
    Product product = productRepo.getReferenceById(productId);

    if (productBoby.getTitle() != null) {
      product.setTitle(productBoby.getTitle());
    }
    if (productBoby.getDescription() != null) {
      product.setDescription(productBoby.getDescription());
    }
    if (productBoby.getImageUrl() != null) {
      product.setImageUrl(productBoby.getImageUrl());
    }
    if (productBoby.getPrice() != null) {
      product.setPrice(productBoby.getPrice());
    }
    if (productBoby.getInStock() != null) {
      product.setInStock(productBoby.getInStock());
    }

    productRepo.save(product);

    return new CreateProduct(
            productBoby.getTitle(),
            productBoby.getDescription(),
            productBoby.getImageUrl(),
            productBoby.getPrice(),
            productBoby.getInStock()
    );
  }

  public void deleteProduct(int id) {
    productRepo.deleteById(id);
  }

}
