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
  void testAddItemToOrder() {

    Item item = entityManager.find(Item.class, 4);
    Order order = entityManager.find(Order.class, 16);

    order.addItem(item);

    orderRepository.save(order);

  }

  @Test
  void testCreateNewOrder() {

    Ticket ticket = entityManager.find(Ticket.class, 15);
    User user = entityManager.find(User.class, 3);

    Order order = new Order(ticket, user);
    order.setTicket(ticket);
    order.setUser(user);
    order.setOrderStatus(OrderStatus.COMPLETA);
    Order saveOrder = orderRepository.save(order);

    assertTrue(saveOrder.getId() > 0);

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