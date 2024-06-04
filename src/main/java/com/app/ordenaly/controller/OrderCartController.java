package com.app.ordenaly.controller;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.dto.OrderCartData;
import com.app.ordenaly.repository.OrderCartRepository;
import com.app.ordenaly.service.OrderCartService;
import com.app.ordenaly.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/carts")
public class OrderCartController {
  @Autowired
  private OrderCartService orderCartService;
  @Autowired
  private OrderCartRepository orderCartRepo;
  @Autowired
  private OrderService orderService;

  @GetMapping("/{oid}")
  public List<OrderCartData> getOrderCart(@PathVariable("oid") int orderId) {
    return orderCartService.getCartByOrder(orderId);
  }

  @GetMapping("/order/{oid}")
  public List<OrderCartData> getOrderCartByOrder(@PathVariable("oid") Order orderId) {
    Order order = orderService.findOrderById(orderId.getId());
    List<OrderCartData> orderCarts = orderCartRepo.findByOrder(order).stream().map(OrderCartData::new).toList();
    return orderCarts;
  }

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
