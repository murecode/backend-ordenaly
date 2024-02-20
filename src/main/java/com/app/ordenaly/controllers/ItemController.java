package com.app.ordenaly.controllers;

import com.app.ordenaly.dto.ItemDto;
import com.app.ordenaly.dto.mapper.ItemMapper;
import com.app.ordenaly.services.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.ordenaly.models.Item;

@RestController
@RequestMapping(value = "/api/v1/items")
public class ItemController {
  @Autowired
  ItemService itemService;
  @Autowired
  ItemMapper itemMapper;

/*  @GetMapping("/{id}")
  public ResponseEntity<ItemDto> getItemById(
          @PathVariable("id") Integer id) {
    Item item = itemService.getItemById(id);
    ItemDto itemDto = itemMapper.itemToItemDto( item );
    return new ResponseEntity<ItemDto>(itemDto, HttpStatus.OK);
  }*/

  @Operation(summary = "Actualizar cantidad", description = "Cambia el valor de 'quantity' del item especificado por su ID")
  @PutMapping("/{id}")
  public ResponseEntity<String> updateQuantity(
          @PathVariable("id") int id,
          @RequestBody ItemDto itemBody) {
    Item item = itemMapper.itemDtoToItem( itemBody );
    itemService.updateQuantity( id, item );
    return new ResponseEntity<>("Item Actualizado", HttpStatus.ACCEPTED);
  }

  /*@DeleteMapping()
  public ResponseEntity<String> deleteItem() {
    return null;
  }*/



}
