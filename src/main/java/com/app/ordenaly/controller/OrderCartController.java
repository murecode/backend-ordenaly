package com.app.ordenaly.controller;

import com.app.ordenaly.model.entities.Order;
import com.app.ordenaly.model.request.OrderCartCreateData;
import com.app.ordenaly.model.response.OrderCartData;
import com.app.ordenaly.infra.repository.OrderCartRepository;
import com.app.ordenaly.service.OrderCartService;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carts")
public class OrderCartController {
  @Autowired
  private OrderCartService orderCartService;
  @Autowired
  private OrderCartRepository orderCartRepo;
  @Autowired
  private OrderService orderService;

  /*@GetMapping("/{id}")
  public List<OrderCartData> getCartByOrder(@PathVariable("id") int orderId) {
    return orderCartService.getCartByOrder(orderId);
  }*/

  @GetMapping("/{id}")
  public List<OrderCartData> getOrderCartByOrder(
          @PathVariable("id") Order orderId) {
    Order order = orderService.findOrderById(orderId.getId());
    List<OrderCartData> orderCarts = orderCartRepo.findByOrder(order).stream()
            .map(OrderCartData::new).toList();
    return orderCarts;
  }

  @PostMapping("/{id}")
  public ResponseEntity<OrderCartData> addProductToCart(
          @PathVariable("id") int orderId,
          @RequestBody OrderCartCreateData orderCartBody) {
    OrderCartData orderCartData = orderCartService.addProductToCart(orderId, orderCartBody);
    return new ResponseEntity<>(orderCartData, HttpStatus.CREATED);
  }


  // +removeProduct()
  // +updateQuantity()

}
