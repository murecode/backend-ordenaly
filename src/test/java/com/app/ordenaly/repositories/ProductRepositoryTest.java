package com.app.ordenaly.repositories;

import com.app.ordenaly.models.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class ProductRepositoryTest {
  @Autowired
  private ProductRepository productRepository;
  @Autowired
  private TestEntityManager entityManager;

  @Test
  void testCreateNewProduct() {

    Product product = new Product();
    product.setProductName("Perro");
    product.setDescription("Delicioso");
    product.setPrice(8000.);
    product.setInStock(true);

    Product saveProduct = productRepository.save(product);

    assertTrue(saveProduct.getId() > 0);
  }

  @Test
  void testUpdateProduct() {
    Product product = entityManager.find(Product.class, 1);
    assertNotNull(product);

    product.setProductName("Pizza Italiana");
    product.setDescription("con queso y pasta de tomate");
    product.setPrice(12000.);
    product.setInStock(true);
    productRepository.save(product);
  }

  @Test
  void testDeleteProductById() {

    Product product = entityManager.find(Product.class, 17);
    assertNotNull(product);

    productRepository.deleteById(product.getId());

    assertTrue(productRepository.findById(product.getId()).isEmpty());
  }



}