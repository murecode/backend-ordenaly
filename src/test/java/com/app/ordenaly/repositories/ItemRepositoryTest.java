package com.app.ordenaly.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.app.ordenaly.models.Product;
import com.app.ordenaly.models.Item;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class ItemRepositoryTest {

  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private TestEntityManager entityManager;

  @Test
  void testAddNewItem() {
    Product product = entityManager.find(Product.class, 15);

    Item newItem = new Item(product, 66);

    Item saveNewProduct = itemRepository.save(newItem);

    assertTrue(saveNewProduct.getId() > 0);

  }



}