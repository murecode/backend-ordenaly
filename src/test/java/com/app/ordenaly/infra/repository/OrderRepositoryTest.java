package com.app.ordenaly.infra.repository;

import com.app.ordenaly.model.entities.Order;
import com.app.ordenaly.model.entities.Ticket;
import com.app.ordenaly.model.enums.PaymentStatus;
import com.app.ordenaly.infra.security.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest //(*)
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class OrderRepositoryTest {
  @Autowired
  private OrderRepository orderRepository;
  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private TestEntityManager entityManager;

  @Test
  void testGenerateNewOrder() {
    Ticket ticket = entityManager.find(Ticket.class, 18);
    User waiter = entityManager.find(User.class, 7);

    Order order = new Order();
    order.setTicket(ticket);
    order.setWaiter(waiter);
    order.setCreatedAt(LocalTime.now());
    order.setTable("Sin defini3");
    order.setOrderComplete(true);
    order.setPaymentStatus(PaymentStatus.PAID);

    Order saveOrder = orderRepository.save(order);

    assertTrue(saveOrder.getId() > 0);
  }

  @Test
  void  testFindEntities() {
    Ticket ticket = entityManager.find(Ticket.class, 17);
    User waiter = entityManager.find(User.class, 3);

    System.out.println(ticket.toString());
    System.out.println(waiter.toString());
  }

  @Test
  void testUpdateOrderStatus() {
    Order order = entityManager.find(Order.class, 2);

    order.setOrderComplete(false);
    order.setPaymentStatus(PaymentStatus.PENDING);

    orderRepository.save(order);

    assertTrue( order.getOrderComplete() == false );
    assertTrue( order.getPaymentStatus() == PaymentStatus.PENDING );
  }

  @Test
  void testDeleteOrder() {
    Order order = entityManager.find(Order.class, 11);
    assertNotNull( order );

    orderRepository.deleteById(order.getId());
  }

}

//(*) Configurar y personalizar las pruebas unitarias centradas en la capa de acceso a datos