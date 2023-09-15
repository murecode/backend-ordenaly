package com.app.ordenaly.repositories;

import com.app.ordenaly.models.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class OrderRepositoryTest {

  @Autowired
  OrderRepository orderRepo;
  @Autowired
  TestEntityManager entityManager;

  @Test
  void testCreateNewOrder() {

    Staff waiter_1 = entityManager.find(Staff.class, 1);
    Ticket ticket_3 = entityManager.find(Ticket.class, 1);

    Order newOrder = new Order();
    newOrder.setTicket(ticket_3);
    newOrder.setStaff(waiter_1);

    Order saveNewOrder = orderRepo.save(newOrder);

    assertTrue(saveNewOrder.getId() > 0);

  }

  @Test
  void testAddItemToOrder() {

    Item item_1 = entityManager.find(Item.class, 1);
    Order order_1 = entityManager.find(Order.class, 1);

    order_1.addItemToOrder(item_1);

  }

}