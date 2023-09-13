package com.app.ordenaly.repositories;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.Product;
import com.app.ordenaly.models.OrderItem;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class OrderItemRepositoryTest {

  @Autowired
  private OrderItemRepository orderItemRepository;
  @Autowired
  private TestEntityManager entityManager;

  @Test
  void testCreateOneOrderItem() {
    Product product = entityManager.find(Product.class, 1);

    OrderItem newOrderItem = new OrderItem();
    newOrderItem.setProduct(product);
    newOrderItem.setQuantity(2);

    OrderItem saveNewProduct = orderItemRepository.save(newOrderItem);

    assertTrue(saveNewProduct.getId() > 0);

  }

}