package com.app.ordenaly.controller;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.OrderMapper;
import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.model.User;
import com.app.ordenaly.repository.TicketRepository;
import com.app.ordenaly.repository.UserRepository;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  @Autowired
  OrderService orderService;
  @Autowired
  OrderMapper orderMapper;

  @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Order> generateOrder(@RequestParam int ticket, @RequestParam int waiter) {
    Order order =  orderService.createOrder(ticket, waiter);
    if(order != null) {
      return new ResponseEntity<>(order, HttpStatus.CREATED);
    } else {
      return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
  }

  @GetMapping("/{id}")
  public Order findOrderById(@PathVariable("id") Integer id) {
    return orderService.getOrder(id);
  }

  @GetMapping("/list")
  public List<OrderDto> listOrders() {
    return orderService.getOrders();
  }

  @DeleteMapping("/remove/{id}")
  public ResponseEntity<Void> removeOrderById(@PathVariable("id") Integer id) {
    orderService.deleteOrder(id);
    return ResponseEntity.noContent().build();
  }




}
