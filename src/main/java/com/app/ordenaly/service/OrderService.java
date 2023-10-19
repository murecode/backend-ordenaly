package com.app.ordenaly.service;

import com.app.ordenaly.model.*;
import com.app.ordenaly.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

  @Autowired
  OrderRepository orderRepo;
  @Autowired
  ItemService itemService;

//  public Order generateOrder(Ticket ticket, Staff waiter) {
//    Order order = new Order();
//    order.setTicket(ticket);
//    order.setStaff(waiter);
//    return order;
//  }

  public Order createOrder() {
    Order order = new Order();
    return orderRepo.save(order);
  }

  public void deleteOrder(Integer id) {
    orderRepo.deleteById(id);
  }

  public Order getOrder(Integer id) {
    return orderRepo.findById(id).orElse(null);
  }

  public List<Order> getAllOrders() {
    return orderRepo.findAll();
  }


}

// Doc

// Optional, clase Java que se utiliza para representar un valor que puede ser nulo o no nulo...
// verificando si un valor está presente o no antes de intentar acceder a él. Ayuda a evitar...
// las excepciones de tipo NullPointerException al acceder a un objeto que puede ser nulo.
