package com.app.ordenaly.test;

import com.app.ordenaly.model.entity.Order;
import com.app.ordenaly.model.entity.Ticket;
import com.app.ordenaly.model.enums.PaymentStatus;
import com.app.ordenaly.model.entity.User;
import com.app.ordenaly.repository.OrderRepository;
import com.app.ordenaly.repository.TicketRepository;
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
    Ticket ticket = entityManager.find(Ticket.class, 8);
    User waiter = entityManager.find(User.class, 8);

    Order order = new Order();
    order.setTicket(ticket);
    order.setWaiter(waiter);
    order.setCreatedAt(LocalTime.now().toString());
    order.setTable("Sin defini3");
    order.setOrderComplete(true);
    order.setPaymentStatus(PaymentStatus.PAID);

    Order saveOrder = orderRepository.save(order);

    assertTrue(saveOrder.getId() > 0);
  }

/*  @Test
  void testUpdateOrderStatus() {
    Order order = entityManager.find(Order.class, 2);

    order.setOrderComplete(false);
    order.setPaymentStatus(PaymentStatus.PENDING);

    orderRepository.save(order);

    assertTrue( order.getOrderComplete() == false );
    assertTrue( order.getPaymentStatus() == PaymentStatus.PENDING );
  }*/

}

//(*) Configurar y personalizar las pruebas unitarias centradas en la capa de acceso a datos