package com.app.ordenaly.repository;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.OrderCart;
import com.app.ordenaly.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class OrderCartRepositoryTest {
  @Autowired
  private OrderCartRepository orderCartRepo;
  @Autowired
  private TestEntityManager entityManager;

  @Test
  void testAddOneOrderCart() {
    Product product = entityManager.find(Product.class, 1);
    Order order = entityManager.find(Order.class, 1);

    OrderCart newOrderItem = new OrderCart();
    newOrderItem.setOrder(order);
    newOrderItem.setProduct(product);
    newOrderItem.setQuantity(4);

    OrderCart savedOrderCart = orderCartRepo.save(newOrderItem);

    assertTrue(savedOrderCart.getId() > 0);

  }

  @Test
  void testGetAllOrderItemsByOrder() {
    Order order = new Order();
    order.setId(1);

    List<OrderCart> orderCarts = orderCartRepo.findByOrder(order);

    assertEquals(1, orderCarts.size());
  }

}