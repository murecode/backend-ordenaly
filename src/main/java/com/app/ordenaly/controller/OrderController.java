package com.app.ordenaly.controller;

import com.app.ordenaly.model.dto.OrderData;
import com.app.ordenaly.repository.OrderRepository;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
  @Autowired
  private OrderService orderService;
  @Autowired
  private OrderRepository orderRepo;


  @GetMapping("")
  public List<OrderData> getOrders() {
    return orderRepo.findAll().stream().map(OrderData::new).toList();
  }

  //generateOrder()
  //updateOrderStatus()

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteOrder(@PathVariable("id") int id) {
    orderService.deleteOrder(id);
    return new ResponseEntity<>("Orden Eliminada", HttpStatus.OK );
  }

}

//DOC

/* Model, es un objeto que se utiliza para transportar datos entre el controlador y la vista. */
