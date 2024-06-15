package com.app.ordenaly.infra.repository;

import com.app.ordenaly.model.Product;
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
    product.setProductName("Sandwich");
    product.setDescription("Delicioso con salsa de ajo");
    product.setPrice(15000);
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
    product.setPrice(25000);
    product.setInStock(true);

    productRepository.save(product);

    assertTrue(product.getId() > 0); //Debe ser igual al primaryKey

  }

  @Test
  void testDeleteProductById() {

    Product product = entityManager.find(Product.class, 2);
    assertNotNull(product);

    productRepository.deleteById(product.getId());

    assertTrue(productRepository.findById(product.getId()).isEmpty());
  }



}