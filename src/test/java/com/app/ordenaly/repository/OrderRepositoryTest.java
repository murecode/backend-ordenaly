package com.app.ordenaly.repository;

import com.app.ordenaly.model.*;
import com.app.ordenaly.model.utils.OrderStatus;
import com.app.ordenaly.model.utils.PaymentStatus;
import com.app.ordenaly.infra.security.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

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
    Ticket ticket = entityManager.find(Ticket.class, 9);
    User waiter = entityManager.find(User.class, 3);

    Order order = new Order();
    order.setTicket(ticket);
    order.setWaiter(waiter);
    order.setTable("Sin defini2");
    order.setAttended(false);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);

    Order saveOrder = orderRepository.save(order);

    assertTrue(saveOrder.getId() > 0);
  }

  @Test
  void  testFindEntities() {
    Ticket ticket = entityManager.find(Ticket.class, 4);
    User waiter = entityManager.find(User.class, 3);

    System.out.println(ticket.toString());
    System.out.println(waiter.toString());
  }

  @Test
  void testUpdateOrderStatus() {
    Order order = entityManager.find(Order.class, 2);

    order.setAttended(false);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);

    orderRepository.save(order);

    assertTrue( order.getAttended() == false );
    assertTrue( order.getPaymentStatus() == PaymentStatus.PENDIENTE );
  }

  @Test
  void testDeleteOrder() {
    Order order = entityManager.find(Order.class, 11);
    assertNotNull( order );

    orderRepository.deleteById(order.getId());
  }

}

//(*) Configurar y personalizar las pruebas unitarias centradas en la capa de acceso a datos