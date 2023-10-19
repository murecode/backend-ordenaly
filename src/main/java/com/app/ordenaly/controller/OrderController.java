package com.app.ordenaly.controller;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/orders")
public class OrderController {
  @Autowired
  OrderService orderService;


  @GetMapping("/{id}")
  public Order findOrderById(@PathVariable("id") Integer id) {
    return orderService.getOrder(id);
  }

  @GetMapping("/list")
  public List<Order> listOrders() {
    return orderService.getAllOrders();
  }

  @DeleteMapping("/remove/{id}")
  public void removeOrderById(@PathVariable("id") Integer id) {
    orderService.deleteOrder(id);
  }

  @PostMapping(path = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
  public Order newOrder(@RequestBody Order order) {
    return orderService.createOrder();
  }
//
//  @PostMapping("/add-to-order/{id}")
//  void itemToOrder(@PathVariable("id") Item id){
//  }
//
//  @GetMapping(value = "/dto/{id}", produces = "application/json")
//  public OrderDTO findOrderDTO(@PathVariable("id") Integer id ) {
//    return orderService.getOrderDTO(id);
//  }

}
