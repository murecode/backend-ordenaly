package com.app.ordenaly.controller;

import com.app.ordenaly.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.ordenaly.model.Item;

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
