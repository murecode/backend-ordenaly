package com.app.ordenaly.services;

import com.app.ordenaly.models.*;
import com.app.ordenaly.models.Employee;
import com.app.ordenaly.repositories.*;
import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 1.
public class OrderService {
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  TicketRepository ticketRepository;
  @Autowired
  EmployeeRepository employeeRepo;
  @Autowired
  ItemService itemService;

  public List<Order> getOrders() {
    return orderRepository.findAll();
  }

  public Order findOrderById(int orderId) {
    return orderRepository.findById( orderId ).orElse(null);
  }

  public void createOrder(Order orderBody) {
    Ticket ticket = ticketRepository.findById(orderBody.getTicket().getId()).orElse(null);
//    Employee waiter = employeeRepo.findById(orderBody.getWaiter().getId()).orElse(null);

    if(ticket.getId() == null) { }

    Order order = new Order();
    order.setTicket( ticket );
//    order.setWaiter( waiter );
    order.setTable( orderBody.getTable() );
    order.setOrderStatus(OrderStatus.PENDIENTE);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);
    order.setNotes(orderBody.getNotes());

    orderRepository.save(order);
  }

  public void addItemToOrder(int orderId, int productId) {
    Order order = orderRepository.findById(orderId).get();

    Item item = itemService.generateItem(productId);
    order.addItem(item);

    orderRepository.save(order);
  }

  public void deleteOrderItem(int itemId) {
    itemService.deleteItem(itemId);
  }

  public void updateOrder(int orderId, Order orderBody) {

    Order order = orderRepository.findById( orderId ).get();
    order.setOrderStatus(orderBody.getOrderStatus());
    order.setPaymentStatus(orderBody.getPaymentStatus());

    orderRepository.save(order);
  }

  public void deleteOrder(Integer id) {
    orderRepository.deleteById(id);
  }

}

// Doc

/* 1. @Service, Spring la trata como un componente administrado por el
contenedor de Spring. Esto significa que Spring administrará su ciclo
de vida, la instancia y la inyección de dependencias en otras clases. */

/* 2. Optional, clase Java que se utiliza para representar un valor que
puede ser nulo o no nulo verificando si un valor está presente o no antes
de intentar acceder a él. Ayuda a evitar las excepciones de tipo
NullPointerException al acceder a un objeto que puede ser nulo. */


