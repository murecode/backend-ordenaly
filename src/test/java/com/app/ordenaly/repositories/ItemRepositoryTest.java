package com.app.ordenaly.repositories;

import com.app.ordenaly.models.Order;
import org.apache.catalina.LifecycleState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.app.ordenaly.models.Product;
import com.app.ordenaly.models.Item;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

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
  void testAddNewItemToOrder() {

    Order order = entityManager.find(Order.class, 16);
    Product product = entityManager.find(Product.class, 30);

    Item item = new Item(product, 3);

    Item saveNewItem = itemRepository.save(item);

    assertTrue(saveNewItem.getId() > 0);
  }

  @Test
  void testDeleteItemFromOrder() {

    Order order = entityManager.find(Order.class, 13);
    Item item = entityManager.find(Item.class, 3);

    itemRepository.deleteById(item.getId());



  }



}