package com.app.ordenaly.controller;

import com.app.ordenaly.dto.ItemDto;
import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.app.ordenaly.model.Item;

import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
  @Autowired
  ItemService itemService;

  @GetMapping("/{id}")
  public Item getItemById(@PathVariable("id") Integer id ) {
    return itemService.getItemById(id);
  }

  @GetMapping("/list")
  public List<ItemDto> listItems() {
    return itemService.getItems();
  }
}
