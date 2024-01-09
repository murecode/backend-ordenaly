package com.app.ordenaly.service;

import com.app.ordenaly.model.User;
import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.OrderMapper;
import com.app.ordenaly.model.*;
import com.app.ordenaly.repository.*;
import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderService {
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  TicketRepository ticketRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  ItemService itemService;


  public List<Order> getOrders() {
    List<Order> orders = orderRepository.findAll();
    return orders;
  }

  public Order findOrderById(int orderId) {
    return orderRepository.findById( orderId ).orElse(null);
  }

//  public Order createOrder(int ticketId, int userId) {
//    Ticket ticket = ticketRepository.findById(ticketId).get();
//    User waiter = userRepository.findById(userId).get();
//
//    Order order = new Order();
//    order.setTicket( ticket );
//    order.setUser( waiter );
//    order.setOrderStatus(OrderStatus.PENDIENTE);
//    order.setPaymentStatus(PaymentStatus.PENDIENTE);
//    order.setItemList(order.getItemList());
//    order.setNotes(order.getNotes());
//    //Se asocia el id de la orden con el ticket
//    ticket.setOrder(order);
//    Order saveOrder = orderRepository.save(order);
//    return saveOrder;
//  }

  public Order createOrder(Order order ) {
    Ticket ticket = ticketRepository.findById( order.getTicket().getId() ).get();
    User waiter = userRepository.findById( order.getUser().getId() ).get();

//    Order order = new Order(  );
    order.setTicket( ticket );
    order.setUser( waiter );
    order.setOrderStatus(OrderStatus.PENDIENTE);
    order.setPaymentStatus(PaymentStatus.PENDIENTE);
    order.setItemList(order.getItemList());
    order.setNotes(order.getNotes());
    //Se asocia el id de la orden con el ticket
    ticket.setOrder(order);
    Order saveOrder = orderRepository.save(order);
    return saveOrder;
  }

  public Order addItemToOrder(int orderId, int productId) {
    Order order = orderRepository.findById(orderId).get();

    Item item = itemService.generateItem(productId);
    order.addItem(item);

    return orderRepository.save(order);
  }

  public Order updateOrder(int orderId, Order orderBody) {
    Order order = orderRepository.findById( orderId ).get();
    order.setOrderStatus(orderBody.getOrderStatus());
    order.setPaymentStatus(orderBody.getPaymentStatus());
    order.setNotes(orderBody.getNotes());
    return orderRepository.save(order);
  }

  public void deleteOrder(Integer id) {
    orderRepository.deleteById(id);
  }

}

// Doc

// Optional, clase Java que se utiliza para representar un valor que puede ser nulo o no nulo...
// verificando si un valor está presente o no antes de intentar acceder a él. Ayuda a evitar...
// las excepciones de tipo NullPointerException al acceder a un objeto que puede ser nulo.
