package com.app.ordenaly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.OrderItem;
import com.app.ordenaly.services.IOrderItemService;

import java.util.List;

@RestController
@RequestMapping(value = "/order-item")
public class OrderItemController {

  @Autowired
  private IOrderItemService orderItemService;

//  @GetMapping(value = "/{id}")
//  public List<OrderItem> findOrderItemsByOrderId(@PathVariable("id") Order id) {
//    return this.orderItemService.findOrderItemsByOrder(id);
//  }

  @GetMapping(value = "/{id}")
  public OrderItem findOrderItemById(@PathVariable("id") Integer id ) {
    return orderItemService.findOrderItemById(id);
  }

}
