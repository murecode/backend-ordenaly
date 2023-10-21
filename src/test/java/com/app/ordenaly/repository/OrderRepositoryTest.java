package com.app.ordenaly.repository;

import com.app.ordenaly.model.*;
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
  void testCreateNewOrder() {
    Ticket ticket = entityManager.find(Ticket.class, 1);
    User waiter = entityManager.find(User.class, 1);

    Order order = new Order();
    order.setTicket(ticket);
    order.setUser(waiter);
    order.setOrderStatus(OrderStatus.PENDIENTE);

    Order saveOrder = orderRepository.save(order);

    assertTrue(saveOrder.getId() > 0);
  }

  @Test
  void testAddItemToOrder() {
    Item item = entityManager.find(Item.class, 4);
    Order order = entityManager.find(Order.class, 16);

    order.addItem(item);

    orderRepository.save(order);

  }



  @Test
  void testUpdateOrder() {

    Order order = entityManager.find(Order.class, 35);
    Ticket ticket = entityManager.find(Ticket.class, 1);
    User user = entityManager.find(User.class, 3);

    order.setTicket(ticket);
    order.setUser(user);
    order.setOrderStatus(OrderStatus.PENDIENTE);

    orderRepository.save(order);
  }

  @Test
  void testDeleteOrderById() {

    Order order = entityManager.find(Order.class, 6);

    orderRepository.deleteById(order.getId());

    assertTrue( order.getId() == 6 );

  }

}