package com.app.ordenaly.services;

import com.app.ordenaly.models.Item;
import com.app.ordenaly.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
  @Autowired
  ItemRepository itemRepo;


  public Item getItemById(Integer id) {
    return itemRepo.findById(id).orElse(null);
  }

  public Item createNewItem() {
    Item item = new Item();
    return item;
  }



}
