package com.app.ordenaly.service;

import com.app.ordenaly.dto.ItemDto;
import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.ItemMapper;
import com.app.ordenaly.model.Item;
import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.Product;
import com.app.ordenaly.repository.ItemRepository;
import com.app.ordenaly.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ItemService {
  @Autowired
  ItemRepository itemRepository;
  @Autowired
  ItemMapper itemMapper;
  @Autowired
  ProductRepository productRepository;

  public Item getItemById(Integer id) {
    return itemRepository.findById(id).orElse(null);
  }

  public Item addItem(Integer productId, Integer quantity) {
    Product product = productRepository.findById(productId).get();
    if (product != null) {
      Item item = new Item(product, quantity);
      itemRepository.save(item);
    }
    return null;
  }

  public List<ItemDto> getItems() { //Prueba
    List<Item> items = itemRepository.findAll();
    return items.stream()
            .map(itemMapper::itemToItemDto)
            .collect(Collectors.toList());
  }

}

// .get() de la clase Optional devuelve el valor si esta presente sino arrojará una excepción NoSuchElementException.
