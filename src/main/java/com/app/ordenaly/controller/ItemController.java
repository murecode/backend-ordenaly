package com.app.ordenaly.controller;

import com.app.ordenaly.dto.ItemDto;
import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.ItemMapper;
import com.app.ordenaly.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.ordenaly.model.Item;

import java.util.List;

@RestController
@RequestMapping(value = "/items")
public class ItemController {
  @Autowired
  ItemService itemService;
  @Autowired
  ItemMapper itemMapper;

  @GetMapping("/{id}")
  public ResponseEntity<ItemDto> getItemById(
          @PathVariable("id") Integer id) {
    Item item = itemService.getItemById(id);
    ItemDto itemDto = itemMapper.itemToItemDto( item );
    return new ResponseEntity<ItemDto>(itemDto, HttpStatus.OK);
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateQuantity(
          @PathVariable("id") int id,
          @RequestBody ItemDto itemBody) {
    Item item = itemMapper.itemDtoToItem( itemBody );
    itemService.updateQuantity( id, item );
    return new ResponseEntity<>("Item Actualizado", HttpStatus.ACCEPTED);
  }



}
