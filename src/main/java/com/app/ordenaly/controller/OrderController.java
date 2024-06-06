package com.app.ordenaly.controller;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.dto.OrderData;
import com.app.ordenaly.model.dto.OrderRequest;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
  @Autowired
  private OrderService orderService;


  @GetMapping("")
  public Page<OrderData> getOrders(Pageable pageable) {
    return orderService.getOrders(pageable);
  }

  @PostMapping("")
  public Order createOrder(@RequestBody OrderRequest orderRequest) {
    return orderService.createOrder(orderRequest);
  }

  //updateOrderStatus() ResponseEntity.status(HttpStatus.CREATED).body(savedOrder)

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteOrder(@PathVariable("id") int id) {
    orderService.deleteOrder(id);
    return new ResponseEntity<>("Orden Eliminada", HttpStatus.OK );
  }

}

//DOC

/* Model, es un objeto que se utiliza para transportar datos entre el controlador y la vista. */
