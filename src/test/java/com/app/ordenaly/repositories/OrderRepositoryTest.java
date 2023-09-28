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

//    Order newOrder = new Order(ticket, waiter);

//    Order saveNewOrder = orderRepository.save(newOrder);

//    assertTrue(saveNewOrder.getId() > 0);

  }

  @Test
  void testAddItemToOrder() {

    Item item_1 = entityManager.find(Item.class, 4);
    Order order_1 = entityManager.find(Order.class, 16);

    order_1.addItem(item_1);

    orderRepository.save(order_1);

  }

  @Test
  void testCreateNewOrder() {

    Ticket ticket = entityManager.find(Ticket.class, 5);
    Staff staff = entityManager.find(Staff.class, 3);

//    Order order = new Order(ticket, staff,);
//    Order saveOrder = orderRepository.save(order);

//    assertTrue(saveOrder.getId() > 0);

  }

//  @Test
//  void testAddNewItemToOrder() {
//
//  }

  @Test
  void testDeleteOrderById() {

    Order order = entityManager.find(Order.class, 6);

    orderRepository.deleteById(order.getId());

    assertTrue( order.getId() == 6 );

  }

}