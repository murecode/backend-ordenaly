package com.app.ordenaly.service;

import com.app.ordenaly.model.*;
import com.app.ordenaly.model.dtos.OrderData;
import com.app.ordenaly.model.dtos.OrderCreateData;
import com.app.ordenaly.model.utils.PaymentStatus;
import com.app.ordenaly.infra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

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

/*  public Order createOrder(int ticketId, int userId) {
    Optional<Ticket> ticket = ticketRepo.findById(ticketId);
    Optional<User> user = userRepo.findById(userId);

    Order order = new Order();
    order.setTicket(ticket.get());
    order.setWaiter(user.get());
    order.setTable(order.getTable());
    order.setOrderStatus(OrderStatus.PENDIENTE);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);

    return orderRepo.save(order);
  }*/

  public OrderData createOrder(OrderCreateData orderRequest) {
    var ticket = ticketRepo.findById(orderRequest.getTicket());
    var waiter = userRepo.findById(orderRequest.getWaiter());

    /*if (ticket.isEmpty() || user.isEmpty()) {
      throw new RuntimeException("Ticket or waiter not found");
    }*/

    Order order = new Order();
    order.setTicket(ticket.get());
    order.setWaiter(waiter.get());
    order.setTable(orderRequest.getTable());
    order.setOrderComplete(false);
    order.setPaymentStatus(PaymentStatus.PENDING);
    //Se relaciona la orden con el Ticket y asi se actualiza el estado del Ticket
    ticket.get().relateToTheOrder(order);

    Order o = orderRepo.save(order);

    return new OrderData(
            o.getId(),
            o.getTicket().getId(),
            o.getTicket().getCreatedAt(),
            o.getWaiter().getName(),
            o.getTable(),
            o.getOrderComplete(),
            o.getPaymentStatus()
    );
  }


  public void updateOrder(int orderId, Order orderBody) {
    Order order = orderRepo.findById( orderId ).get();
//    order.setOrderStatus(orderBody.getOrderStatus());
    order.setPaymentStatus(orderBody.getPaymentStatus());

    orderRepo.save(order);
  }

  public void deleteOrder(int id) {
    Order order = orderRepo.findById(id).get();
    // Validaciones
    orderRepo.deleteById(order.getId());
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


