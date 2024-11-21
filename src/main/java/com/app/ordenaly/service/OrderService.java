package com.app.ordenaly.service;

import com.app.ordenaly.model.enums.OrderStatus;
import com.app.ordenaly.presentation.advice.exception.ticket_exception.TicketAlreadyUsedException;
import com.app.ordenaly.repository.OrderRepository;
import com.app.ordenaly.repository.TicketRepository;
import com.app.ordenaly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import com.app.ordenaly.presentation.advice.exception.order_exception.OrderNotFoundException;
import com.app.ordenaly.model.entity.User;
import com.app.ordenaly.model.enums.TicketStatus;
import com.app.ordenaly.presentation.response.OrderData;
import com.app.ordenaly.presentation.request.OrderRequest;
import com.app.ordenaly.model.entity.Order;
import com.app.ordenaly.model.entity.Ticket;
import com.app.ordenaly.model.enums.PaymentStatus;

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
            o.getOrderStatus(),
            o.getPaymentStatus()
    )).orElseThrow(() -> new OrderNotFoundException("La orden no fue encontrada"));
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
            o.getOrderStatus(),
            o.getPaymentStatus()
    ));
  }

  public Page<OrderData> getOrdersByStatus(
          OrderStatus status, Pageable pageable) {

    Page<Order> orders = orderRepo.findByOrderStatus(status, pageable);

    return orders.map(o -> new OrderData(
            o.getId(),
            o.getTicket().getId(),
            o.getTicket().getCreatedAt(),
            o.getWaiter().getName(),
            o.getTable(),
            o.getTicket().getNumberOfPeople(),
            o.getOrderStatus(),
            o.getPaymentStatus()
    ));
  }

  //get orders by waiter
  public Page<OrderData> getOrdersByWaiter(User waiter, Pageable pageable) {

    Page<Order> orders = orderRepo.findByWaiter(waiter, pageable);

    return orders.map(o -> new OrderData(
            o.getId(),
            o.getTicket().getId(),
            o.getTicket().getCreatedAt(),
            o.getWaiter().getName(),
            o.getTable(),
            o.getTicket().getNumberOfPeople(),
            o.getOrderStatus(),
            o.getPaymentStatus()
    ));

  }

  @Transactional
  public OrderData createOrder(OrderRequest orderBody) {

    Ticket ticket = ticketRepo.findById(orderBody.getTicket()).get();

    if (ticket == null) {
      throw new IllegalArgumentException("El campo ticket no puede ser null");
    }

    if (orderBody.getTicket() == ticket.getId()) {
      throw new TicketAlreadyUsedException("El Ticket " + ticket.getId() + " ya esta asignado a una Comanda");
    }

    User waiter = userRepo.findById(orderBody.getWaiter()).get();
    if (waiter == null) {
      throw new IllegalArgumentException("El campo Waiter no puede ser null");
    }

    Order order = new Order();
    order.setTicket(ticket);
    order.setWaiter(waiter);
    order.setCreatedAt(ticket.getCreatedAt().toString());
    order.setTable(orderBody.getTable());
    order.setOrderStatus(OrderStatus.IN_PROGRESS);
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
            o.getOrderStatus(),
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


