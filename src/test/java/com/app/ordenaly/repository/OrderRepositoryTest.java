package com.app.ordenaly.repository;

import com.app.ordenaly.model.User;
import com.app.ordenaly.model.*;
import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
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
  private ItemRepository itemRepository;
  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private TestEntityManager entityManager;

  @Test
  void testGenerateOrder() {
    Ticket ticket = entityManager.find(Ticket.class, 14);
    User waiter = entityManager.find(User.class, 30);

    Order order = new Order();
    order.setTicket(ticket);
    order.setUser(waiter);
    order.setOrderStatus(OrderStatus.PENDIENTE);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);
    order.setNotes("Agregar nota");

    Order saveOrder = orderRepository.save(order);

    //Se asocia el id de la orden con el ticket
    ticket.setOrder(order);

    assertTrue(saveOrder.getId() > 0);
  }

  @Test
  void testAddItemToOrder() {
    Order order = entityManager.find(Order.class, 5);
    Product product = entityManager.find(Product.class, 5);

      Item item = new Item();
      item.setProduct(product);
      item.setQuantity(item.getQuantity());
      itemRepository.save(item);

      order.addItem(item);

      orderRepository.save(order);
  }

  @Test
  void testDeleteItem() {
    Item item = entityManager.find(Item.class, 8);

    itemRepository.deleteById(item.getId());
  }

  @Test
  void testUpdateOrderStatus() {
    Order order = entityManager.find(Order.class, 6);

    order.setOrderStatus(OrderStatus.ATENDIDA);
    order.setPaymentStatus(PaymentStatus.REALIZADO);

    orderRepository.save(order);

    assertTrue( order.getOrderStatus() == OrderStatus.ATENDIDA );
    assertTrue( order.getPaymentStatus() == PaymentStatus.REALIZADO);
  }

  @Test
  void testDeleteOrder() {
    Order order = entityManager.find(Order.class, 10);
    orderRepository.deleteById(order.getId());
    assertTrue( order.getId() == 10 );
  }

}

//(*) Configurar y personalizar las pruebas unitarias centradas en la capa de acceso a datos