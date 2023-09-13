package com.app.ordenaly.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ordenaly.models.Item;
import com.app.ordenaly.services.IItemService;

import java.util.List;

@RestController
@RequestMapping(value = "/api/item")
public class ItemController {

  @Autowired
  private IItemService orderItemService;

  @GetMapping(value = "/{id}")
  public List<Item> findItemsByOrderId(@PathVariable("id") Integer id) {
    return null;
  }

  @GetMapping(value = "/{id}")
  public Item findItemById(@PathVariable("id") Integer id ) {
    return orderItemService.findOrderItemById(id);
  }

}
