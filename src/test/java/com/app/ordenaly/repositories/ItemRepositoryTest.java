package com.app.ordenaly.repositories;

import com.app.ordenaly.models.Order;
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
  void testAddItemToOrder() {
    Order order = entityManager.find(Order.class, 29);
    Product product = entityManager.find(Product.class, 5);

    Item item = new Item();
    item.setProduct(product);
    item.setQuantity(item.getQuantity());
    itemRepository.save(item);

    order.addItem(item);
  }

  @Test
  void testDeleteItem() {
    Item item = entityManager.find(Item.class, 3);

    itemRepository.deleteById(item.getId());

    assertTrue( item.getId() != null );
  }


}