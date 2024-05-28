package com.app.ordenaly.repository;

import com.app.ordenaly.model.*;
import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;
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
  void testGenerateOrder() {
    Ticket ticket = entityManager.find(Ticket.class, 2);
    Employee waiter = entityManager.find(Employee.class, 1);

    Order order = new Order();
    order.setTicket(ticket);
    order.setWaiter(waiter);
    order.setTable(6);
    order.setOrderStatus(OrderStatus.PENDIENTE);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);
    order.setNotes("Prueba con nueva clase Empleado");

    Order saveOrder = orderRepository.save(order);

    assertTrue(saveOrder.getId() > 0);
//    assertTrue(waiter.getId().equals( 2 ));
  }

  @Test
  void testUpdateOrderStatus() {
    Order order = entityManager.find(Order.class, 2);

    order.setOrderStatus(OrderStatus.PENDIENTE);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);

    orderRepository.save(order);

    assertTrue( order.getOrderStatus() == OrderStatus.PENDIENTE );
    assertTrue( order.getPaymentStatus() == PaymentStatus.PENDIENTE );
  }

  @Test
  void testDeleteOrder() {
    Order order = entityManager.find(Order.class, 29);
    assertNotNull( order );

    orderRepository.deleteById(order.getId());
  }

}

//(*) Configurar y personalizar las pruebas unitarias centradas en la capa de acceso a datos