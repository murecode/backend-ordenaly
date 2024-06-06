package com.app.ordenaly.service;

import com.app.ordenaly.model.*;
import com.app.ordenaly.model.dto.OrderData;
import com.app.ordenaly.model.dto.OrderRequest;
import com.app.ordenaly.model.utils.OrderStatus;
import com.app.ordenaly.model.utils.PaymentStatus;
import com.app.ordenaly.repository.*;
import com.app.ordenaly.security.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service // 1.
public class OrderService {
  @Autowired
  private OrderRepository orderRepo;
  @Autowired
  private TicketRepository ticketRepo;
  @Autowired
  private UserRepository userRepo;


  public Page<OrderData> getOrders(Pageable pageable) {
    return orderRepo.findAll(pageable).map(OrderData::new);
  }

  public Order findOrderById(int orderId) {
    return orderRepo.findById( orderId ).orElse(null);
  }

  public Order createOrder(OrderRequest orderRequest) {
    Optional<Ticket> ticket = ticketRepo.findById(orderRequest.ticket());
    Optional<User> waiter = userRepo.findById(orderRequest.waiter());

    Order order = new Order();
    order.setWaiter(waiter.orElseThrow(() -> new RuntimeException("Ticket Not Found")));
    order.setTicket(ticket.orElseThrow(() -> new RuntimeException("Ticket Not Found")));
    order.setTable(orderRequest.table());
    order.setOrderStatus(OrderStatus.PENDIENTE);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);

    return orderRepo.save(order);
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


