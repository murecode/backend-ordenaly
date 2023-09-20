package com.app.ordenaly.repositories;

import com.app.ordenaly.models.*;
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
class OrderRepositoryTest {

  @Autowired
  OrderRepository orderRepository;
  @Autowired
  TestEntityManager entityManager;

  @Test
  void testGenerateNewOrder() {

    Staff waiter = entityManager.find(Staff.class, 2);
    Ticket ticket = entityManager.find(Ticket.class, 3);

    Order newOrder = new Order(ticket, waiter);

    Order saveNewOrder = orderRepository.save(newOrder);

    assertTrue(saveNewOrder.getId() > 0);

  }

  @Test
  void testAddItemToOrder() {

    Item item_1 = entityManager.find(Item.class, 21);
    Order order_1 = entityManager.find(Order.class, 13);

    order_1.addItemToOrder(item_1);

  }

  @Test
  void testCreateNewOrder() {

    Ticket ticket = entityManager.find(Ticket.class, 1);
    Staff staff = entityManager.find(Staff.class, 2);

    Order order = new Order(ticket, staff);
    Order saveOrder = orderRepository.save(order);

    assertTrue(saveOrder.getId() > 0);

  }

  @Test
  void testAddNewItemToOrder() {

    Order thisOrder = entityManager.find(Order.class, 13);
    Product product = entityManager.find(Product.class, 16);

    Item newItem = new Item(product, 3);

    thisOrder.addItemToOrder(newItem);

    assertTrue(thisOrder.getItems().contains(newItem));

  }

  @Test
  void testDeleteOrderById() {

    Order order = entityManager.find(Order.class, 33);

    orderRepository.deleteById(order.getId());

    assertTrue( order.getId() == 33 );

  }

}