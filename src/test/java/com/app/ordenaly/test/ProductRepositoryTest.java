package com.app.ordenaly.test;

import com.app.ordenaly.model.entity.Product;
import com.app.ordenaly.model.entity.ProductCategory;
import com.app.ordenaly.repository.ProductRepository;
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

    ProductCategory productCategory = entityManager.find(ProductCategory.class, 5);

    Product product = new Product();
    product.setTitle("Pan Arabe");
    product.setDescription("Traido de arabia saudita");
    product.setCategory(productCategory);
    product.setPrice(8000);
    product.setInStock(false);

    Product saveProduct = productRepository.save(product);

    assertTrue(saveProduct.getId() > 0);
  }

  @Test
  void testUpdateProduct() {
    Product product = entityManager.find(Product.class, 23);
    ProductCategory category = entityManager.find(ProductCategory.class, 6);

    assertNotNull(product);

    product.setCategory(category);
    product.setTitle("Actualizado");
    product.setDescription("Actualizado");
    product.setPrice(2500);
    product.setInStock(false);

    productRepository.save(product);

    assertTrue(product.getId() == 23); //Debe ser igual al primaryKey

  }

 /* @Test
  void testDeleteProductById() {

    Product product = entityManager.find(Product.class, 2);
    assertNotNull(product);

    productRepository.deleteById(product.getId());

    assertTrue(productRepository.findById(product.getId()).isEmpty());
  }*/



}