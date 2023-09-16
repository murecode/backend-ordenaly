package com.app.ordenaly.controllers;

import com.app.ordenaly.services.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ordenaly.models.Item;

import java.util.List;

@RestController
@RequestMapping(value = "/api/item")
public class ItemController {

  @Autowired
  ItemService itemService;

  @GetMapping(value = "/list")
  public List<Item> listAllItems() {
    return itemService.getAllItems();
  }

  @GetMapping(value = "/{id}")
  public Item findItemById(@PathVariable("id") Integer id ) {
    return itemService.getItemById(id);
  }

}
