package com.app.ordenaly.controllers;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ordenaly.models.Item;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/items")
public class ItemController {

  @Autowired
  ItemService itemService;


  @GetMapping("/{id}")
  public Item getItemById(@PathVariable("id") Integer id ) {
    return itemService.getItemById(id);
  }

  @GetMapping("/order-items/{id}")
  public List<Item> getItemsByOrder(@PathVariable("id") Integer order_id){
    return itemService.getItemsByOrderId(order_id);
  }

}
