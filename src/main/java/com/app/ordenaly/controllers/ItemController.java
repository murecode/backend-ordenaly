package com.app.ordenaly.controllers;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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

  @PostMapping("/new/{productId}/{quantity}")
  public Item createItem(
          @PathVariable(name = "productId") Integer product_id,
          @PathVariable(name = "quantity") Integer quantity) {
    return itemService.addItem(product_id, quantity);
  }
}
