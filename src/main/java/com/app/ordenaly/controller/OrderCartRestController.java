package com.app.ordenaly.controller;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.service.OrderCartService;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderCartRestController {
  @Autowired
  private OrderCartService orderCartService;
  @Autowired
  private OrderService orderService;


  @PostMapping("/add/{pid}/{qty}/{oid}")
  public String addProductToCart(
          @PathVariable("pid") int productId,
          @PathVariable("qty") int quantity,
          @PathVariable("oid") int orderId) {

    Order order = orderService.findOrderById(orderId);

    if (order == null) return "La orden no existe";

    int addedQuantity = orderCartService.addProductToCart(productId, quantity, order);

    return addedQuantity + " producto/s agregado/s a la orden";
  }


  // +removeProduct()
  // +updateQuantity()

}
