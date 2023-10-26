package com.app.ordenaly.repository;

import com.app.ordenaly.model.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.app.ordenaly.model.Product;
import com.app.ordenaly.model.Item;

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
  void testDeleteItemFromOrder() {

    Order order = entityManager.find(Order.class, 13);
    Item item = entityManager.find(Item.class, 3);

    itemRepository.deleteById(item.getId());



  }



}