package com.app.ordenaly.services;

import com.app.ordenaly.DTOs.OrderDTO;
import com.app.ordenaly.models.Item;
import com.app.ordenaly.models.Order;
import com.app.ordenaly.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

  @Autowired
  OrderRepository orderRepo;

  public Order createOrder() {
    Order order = new Order();
    return order;
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
