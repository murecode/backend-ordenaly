package com.app.ordenaly.controller;

import com.app.ordenaly.model.entity.User;
import com.app.ordenaly.model.enums.OrderStatus;
import com.app.ordenaly.model.enums.PaymentStatus;
import com.app.ordenaly.presentation.response.OrderData;
import com.app.ordenaly.presentation.request.OrderRequest;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {
  @Autowired
  private OrderService orderService;


  @GetMapping("")
  public Page<OrderData> getOrders(
          @PageableDefault(
                  page = 0,
                  size = 10,
                  sort = {"ticketId"},
                  direction = Sort.Direction.ASC)
          Pageable pageable) {
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

  @GetMapping("/order_status/{status}")
  public  Page<OrderData> getOrdersByOrderStatus(
          @PathVariable("status") OrderStatus status,
          Pageable pageable) {
    return orderService.getOrdersByStatus(status, pageable);
  }

  @GetMapping("/waiters/{id}")
  public  Page<OrderData> getOrdersByWaiter(
          @PathVariable("id") User user,
          Pageable pageable) {
    return orderService.getOrdersByWaiter(user, pageable);
  }

  @PostMapping("")
  public ResponseEntity<OrderData> createOrder(
          @RequestBody OrderRequest orderBody) {
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
