package com.app.ordenaly.service;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.OrderMapper;
import com.app.ordenaly.model.*;
import com.app.ordenaly.repository.OrderRepository;
import com.app.ordenaly.repository.TicketRepository;
import com.app.ordenaly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.apache.coyote.http11.Constants.a;

@Service
public class OrderService {
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  TicketRepository ticketRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  OrderMapper orderMapper;


  public Order createOrder(int ticket, int user) {

    Ticket turno = ticketRepository.findById(ticket).orElse(null);
    User mesero = userRepository.findById(user).orElse(null);

    if (turno != null && mesero != null) {
      Order newOrder = new Order();
      newOrder.setTicket(turno);
      newOrder.setUser(mesero);
      newOrder.setOrderStatus(OrderStatus.PENDIENTE);

      //Se asocia el id de la orden con el ticket
      turno.setOrder(newOrder);

      Order saveOrder = orderRepository.save(newOrder);

      return saveOrder;

    } else {
      return null;
    }
  }

  public void deleteOrder(Integer id) {
    orderRepository.deleteById(id);
  }

  public Order getOrder(Integer id) {
    return orderRepository.findById(id).orElse(null);
  }

 /* public List<Order> getAllOrders() {
    return orderRepository.findAll();
  }*/

  public List<OrderDto> getOrders() {
    List<Order> orders = orderRepository.findAll();
    return orders.stream()
            .map(orderMapper::orderToOrderDto)
            .collect(Collectors.toList());
  }


}

// Doc

// Optional, clase Java que se utiliza para representar un valor que puede ser nulo o no nulo...
// verificando si un valor está presente o no antes de intentar acceder a él. Ayuda a evitar...
// las excepciones de tipo NullPointerException al acceder a un objeto que puede ser nulo.
