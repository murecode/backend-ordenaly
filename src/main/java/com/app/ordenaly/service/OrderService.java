package com.app.ordenaly.service;

import com.app.ordenaly.infra.exceptions.custom_exceptions.ResourceNotFoundExeption;
import com.app.ordenaly.model.entities.User;
import com.app.ordenaly.model.enums.TicketStatus;
import com.app.ordenaly.model.response.OrderData;
import com.app.ordenaly.model.request.OrderRequest;
import com.app.ordenaly.model.entities.Order;
import com.app.ordenaly.model.entities.Ticket;
import com.app.ordenaly.model.enums.PaymentStatus;
import com.app.ordenaly.infra.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service //1.
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

  public OrderData getOrderById(int orderId) {

    Optional<Order> orders = orderRepo.findById(orderId);

    return orders.map(o -> new OrderData(
            o.getId(),
            o.getTicket().getId(),
            o.getTicket().getCreatedAt(),
            o.getWaiter().getName(),
            o.getTable(),
            o.getTicket().getNumberOfPeople(),
            o.getOrderComplete(),
            o.getPaymentStatus()
    )).orElseThrow(() -> new ResourceNotFoundExeption("La orden no fue encontrada"));
  }

  public Page<OrderData> getOrdersByPaymentStatus(
          PaymentStatus status, Pageable pageable) {

    Page<Order> orders = orderRepo.findByPaymentStatus(status, pageable);

    return orders.map(o -> new OrderData(
            o.getId(),
            o.getTicket().getId(),
            o.getTicket().getCreatedAt(),
            o.getWaiter().getName(),
            o.getTable(),
            o.getTicket().getNumberOfPeople(),
            o.getOrderComplete(),
            o.getPaymentStatus()
    ));
  }

  public Page<OrderData> getOrdersByIsComplete(
          Boolean iscomplete, Pageable pageable) {

    Page<Order> orders = orderRepo.findByIsComplete(iscomplete, pageable);

    return orders.map(o -> new OrderData(
            o.getId(),
            o.getTicket().getId(),
            o.getTicket().getCreatedAt(),
            o.getWaiter().getName(),
            o.getTable(),
            o.getTicket().getNumberOfPeople(),
            o.getOrderComplete(),
            o.getPaymentStatus()
    ));
  }

  @Transactional
  public OrderData createOrder(OrderRequest orderBody) {

    Ticket ticket = ticketRepo.findById(orderBody.getTicket()).get();
    if (ticket == null) {
      throw new IllegalArgumentException("Ticket cannot be null");
    }

    User waiter = userRepo.findById(orderBody.getWaiter()).get();
    if (waiter == null) {
      throw new IllegalArgumentException("Waiter cannot be null");
    }

    Order order = new Order();
    order.setTicket(ticket);
    order.setWaiter(waiter);
    order.setCreatedAt(ticket.getCreatedAt().toString());
    order.setTable(orderBody.getTable());
    order.setOrderComplete(false);
    order.setPaymentStatus(PaymentStatus.PENDING);

    // Actualizar el estado del ticket
    ticketRepo.updateTicketStatus(orderBody.getTicket(), TicketStatus.ATTENDED);

    Order o = orderRepo.save(order);

    return new OrderData(
            o.getId(),
            o.getTicket().getId(),
            o.getTicket().getCreatedAt(),
            o.getWaiter().getName(),
            o.getTable(),
            o.getTicket().getNumberOfPeople(),
            o.getOrderComplete(),
            o.getPaymentStatus()
    );
  }

  public void deleteOrder(int id) {
    Optional<Order> orderOptional = orderRepo.findById(id);
    if (!orderOptional.isPresent()) {
      throw new RuntimeException("Orden no encontrada");
    }

    Order order = orderOptional.get();

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


