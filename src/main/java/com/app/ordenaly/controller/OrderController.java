package com.app.ordenaly.controller;

import com.app.ordenaly.model.dtos.order.OrderData;
import com.app.ordenaly.model.dtos.order.OrderCreateData;
import com.app.ordenaly.service.OrderService;
import jakarta.validation.Valid;
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

  /*@PostMapping("/{ticketid}/{userid}")
  public ResponseEntity<OrderData> createOrder(
          @PathVariable("ticketid") int ticketId,
          @PathVariable("userid") int userId) {
    Order order = orderService.createOrder(ticketId, userId);
    OrderData orderData = new OrderData(
            order.getId(),
            order.getTicket().getId(),
            order.getTicket().getTime().toString(),
            order.getWaiter().getName(),
            order.getTable(),
            order.getOrderStatus(),
            order.getPaymentStatus());
    return new ResponseEntity<>(orderData, HttpStatus.CREATED);
  }*/

  @PostMapping("")
  public ResponseEntity<OrderData> createOrder(
          @RequestBody OrderCreateData orderBody) {
    OrderData order = orderService.createOrder(orderBody);
    return new ResponseEntity<>(order, HttpStatus.CREATED);
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
