package com.app.ordenaly.controllers;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.models.Ticket;
import com.app.ordenaly.services.ItemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.ordenaly.models.Item;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/items")
public class ItemController {
  @Autowired
  ItemService itemService;
  @Autowired


  @GetMapping("")
  public ResponseEntity<List<Item>>  getItems() {
    List<Item> items = itemService.getItems();
    return new ResponseEntity<>(items, HttpStatus.OK);
  }

  @Operation(summary = "Actualizar cantidad", description = "Cambia el valor de 'quantity' del item especificado por su ID")
  @PutMapping("/{id}")
  public ResponseEntity<String> updateQuantity(
          @PathVariable("id") int id,
          @RequestBody Item itemBody) {
    itemService.updateQuantity( id, itemBody );
    return new ResponseEntity<>("Item Actualizado", HttpStatus.ACCEPTED);
  }


}
