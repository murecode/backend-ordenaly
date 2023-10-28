package com.app.ordenaly.service;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.ProductDto;
import com.app.ordenaly.dto.mapper.OrderMapper;
import com.app.ordenaly.model.*;
import com.app.ordenaly.repository.OrderRepository;
import com.app.ordenaly.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderService {
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  TicketRepository ticketRepository;
  @Autowired
  OrderMapper orderMapper;

//  public Order generateOrder(Ticket ticket, Staff waiter) {
//    Order order = new Order();
//    order.setTicket(ticket);
//    order.setStaff(waiter);
//    return order;
//  }

  public Order createOrder(OrderDto orderDto) {
    Order order = orderMapper.orderDtoToOrder(orderDto);
    return orderRepository.save(order);
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
