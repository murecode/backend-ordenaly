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
  private OrderRepository orderRepository;
  @Autowired
  private ItemRepository itemRepository;
  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private TestEntityManager entityManager;

  @Test
  void testGenerateOrder() {
    Ticket ticket = entityManager.find(Ticket.class, 7);
    User waiter = entityManager.find(User.class, 2);

    Order order = new Order();
    order.setTicket(ticket);
    order.setUser(waiter);
    order.setOrderStatus(OrderStatus.PENDIENTE);

    //Se asocia el id de la orden con el ticket
    ticket.setOrder(order);

    Order saveOrder = orderRepository.save(order);

    assertTrue(saveOrder.getId() > 0);
  }

  @Test
  void testAddItemToOrder() {
    Order order = entityManager.find(Order.class, 14);
    Product product = entityManager.find(Product.class, 2);

    Item item = new Item(product, 3);
    Item saveNewItem = itemRepository.save(item);

    order.addItem(item);

    orderRepository.save(order);
  }

  @Test
  void testDeleteItem() {
    //Arroja error porque esta ligada a la entidad producto
    Item item = entityManager.find(Item.class, 6);

    itemRepository.deleteById(item.getId());
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
  void testDeleteOrder() {
    Order order = entityManager.find(Order.class, 14);

    orderRepository.deleteById(order.getId());

    assertTrue( order.getId() == 14 );
  }

}