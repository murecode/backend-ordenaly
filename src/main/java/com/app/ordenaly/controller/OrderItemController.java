package com.app.ordenaly.controller;

import com.app.ordenaly.model.request.OrderCartRequest;
import com.app.ordenaly.model.response.OrderItemData;
import com.app.ordenaly.infra.repository.OrderItemRepository;
import com.app.ordenaly.service.OrderItemService;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/items")
public class OrderItemController {
  @Autowired
  private OrderItemService orderItemService;
  @Autowired
  private OrderItemRepository orderCartRepo;
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
  public List<OrderItemData> getOrderItemsByOrderId(
          @PathVariable("id") int orderId) {
    return orderItemService.getCartByOrder(orderId);
  }

  @PostMapping("/orders/{id}")
  public ResponseEntity<OrderItemData> addItemToOrder(
          @PathVariable("id") int orderId,
          @RequestBody OrderCartRequest orderCartBody) {
    OrderItemData orderItemData = orderItemService.addProductToCart(orderId, orderCartBody);
    return new ResponseEntity<>(orderItemData, HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity removeOneItemFromOrder(
          @PathVariable("id") int id) {
    orderItemService.deleteProductFromCart(id);
    return ResponseEntity.noContent().build();
  }

  @PatchMapping("/{id}")
  public ResponseEntity<OrderItemData> updateItemQuantity(
          @PathVariable("id") int ordercartId,
          @RequestBody OrderCartRequest orderCartBody) {
    OrderItemData updatedOrderCart = orderItemService.updateQuantity(ordercartId, orderCartBody);
    return new ResponseEntity<>(updatedOrderCart, HttpStatus.ACCEPTED);
  }

}
