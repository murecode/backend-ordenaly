package com.app.ordenaly.controller;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.OrderMapper;
import com.app.ordenaly.model.Order;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
  @Autowired
  OrderService orderService;
  @Autowired
  OrderMapper orderMapper;

  @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Order> generateOrder(@RequestParam int ticket, @RequestParam int waiter) {
    Order order =  orderService.createOrder(ticket, waiter);
    return new ResponseEntity<>(order, HttpStatus.OK);
  }

  @PostMapping(value = "/add", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Order>  createItem(
          @RequestParam(name = "orderId") int orderId,
          @RequestParam(name = "productId") int productId,
          @RequestParam(name = "quantity") int quantity) {
    Order item = orderService.addItemToOrder(orderId, productId, quantity);
    return new ResponseEntity<>(item, HttpStatus.ACCEPTED);
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderDto> getOrder(@PathVariable Integer id) {
    OrderDto orderDto = orderService.findOrderById( id );
    if (orderDto != null) {
      return ResponseEntity.ok(orderDto);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @GetMapping("/list")
  public List<OrderDto> listOrders() {
    return orderService.getOrders();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removeOrderById(@PathVariable("id") Integer id) {
    orderService.deleteOrder(id);
    return new ResponseEntity<>( HttpStatus.OK );
  }

}
