package com.app.ordenaly.service;

import com.app.ordenaly.model.*;
import com.app.ordenaly.model.Staff;
import com.app.ordenaly.repository.*;
import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service // 1.
public class OrderService {
  @Autowired
  private OrderRepository orderRepo;
  @Autowired
  private TicketRepository ticketRepo;
  @Autowired
  private StaffRepository staffRepo;


  public List<Order> getOrders() {
    return orderRepo.findAll();
  }

  public Order findOrderById(int orderId) {
    return orderRepo.findById( orderId ).orElse(null);
  }

  public void createOrder(Order orderBody) {
    Ticket ticket = ticketRepo.findById(orderBody.getTicket().getId()).orElse(null);
    Staff waiter = staffRepo.findById(orderBody.getWaiter().getId()).orElse(null);

    Order order = new Order();
    order.setTicket( ticket );
    order.setWaiter( waiter );
    order.setTable(orderBody.getTable());
    order.setOrderStatus(OrderStatus.PENDIENTE);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);

    orderRepo.save(order);
  }

  public void updateOrder(int orderId, Order orderBody) {

    Order order = orderRepo.findById( orderId ).get();
    order.setOrderStatus(orderBody.getOrderStatus());
    order.setPaymentStatus(orderBody.getPaymentStatus());

    orderRepo.save(order);
  }

  public void deleteOrder(Integer id) {
    orderRepo.deleteById(id);
  }

}

// Docs

/*1. @Service, se configura como un componente administrado por el
contenedor de Spring. Esto significa que Spring administrará su ciclo
de vida, la instancia y la inyección de dependencias en otras clases. */

/*2. Optional, clase Java que se utiliza para representar un valor que
puede ser nulo o no verificando si un valor está presente o no antes
de intentar acceder a él. Ayuda a evitar las excepciones de tipo
NullPointerException al acceder a un objeto que puede ser nulo. */


