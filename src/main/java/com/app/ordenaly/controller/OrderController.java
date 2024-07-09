package com.app.ordenaly.controller;

import com.app.ordenaly.model.enums.PaymentStatus;
import com.app.ordenaly.model.response.OrderData;
import com.app.ordenaly.model.request.CreateOrder;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
  @Autowired
  private OrderService orderService;


  @GetMapping("")
  public Page<OrderData> getOrders(Pageable pageable) {
    return orderService.getOrders(pageable);
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderData> getOrder(
          @PathVariable("id") int orderId ) {
    OrderData order = orderService.getOrderById(orderId);
    return new ResponseEntity<>(order, HttpStatus.OK);
  }

  @GetMapping("/status/{status}")
  public Page<OrderData> getOrdersByPayment(
          @PathVariable("status") PaymentStatus status,
          Pageable pageable) {
    return orderService.getOrdersByPaymentStatus(status, pageable);
  }

  @GetMapping("/completed/{is}")
  public  Page<OrderData> getOrdersByIsComplete(
          @PathVariable("is") Boolean iscomplete,
          Pageable pageable) {
    return orderService.getOrdersByIsComplete(iscomplete, pageable);
  }

  @PostMapping("")
  public ResponseEntity<OrderData> createOrder(
          @RequestBody CreateOrder orderBody) {
    OrderData order = orderService.createOrder(orderBody);
    return new ResponseEntity<>(order, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteOrder(@PathVariable("id") int id) {
    orderService.deleteOrder(id);
    return new ResponseEntity<>("Orden Eliminada", HttpStatus.OK );
  }

}

//DOC

/* Model, es un objeto que se utiliza para transportar datos entre el controlador y la vista. */
