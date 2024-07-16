package com.app.ordenaly.controller;

import com.app.ordenaly.model.request.OrderCartRequest;
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

/*
  @GetMapping("/{id}")
  public List<OrderCartData> getCartByOrder(
          @PathVariable("id") int orderId) {
    return orderCartService.getCartByOrder(orderId);
  }
*/

  @GetMapping("/orders/{id}")
  public List<OrderCartData> getOrderCartByOrder(
          @PathVariable("id") int orderId) {
    return orderCartService.getCartByOrder(orderId);
  }

  @PostMapping("/{id}")
  public ResponseEntity<OrderCartData> addProductToCart(
          @PathVariable("id") int orderId,
          @RequestBody OrderCartRequest orderCartBody) {
    OrderCartData orderCartData = orderCartService.addProductToCart(orderId, orderCartBody);
    return new ResponseEntity<>(orderCartData, HttpStatus.CREATED);
  }

  @DeleteMapping("/product/{id}")
  public ResponseEntity removeProductFromCart(
          @PathVariable("id") int id) {
    orderCartService.deleteProductFromCart(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<OrderCartData> updateQuantity(
          @PathVariable("id") int ordercartId,
          @RequestBody OrderCartRequest orderCartBody) {
    OrderCartData updatedOrderCart = orderCartService.updateQuantity(ordercartId, orderCartBody);
    return new ResponseEntity<>(updatedOrderCart, HttpStatus.ACCEPTED);
  }

}
