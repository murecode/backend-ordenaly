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

  public Item getItemById(int id) {
    return itemRepository.findById(id).orElse(null);
  }

  public Item generateItem(int productId) {
    Product product = productRepository.findById(productId).get();
      Item item = new Item();
      item.setProduct(product);
      item.setQuantity(item.getQuantity());
      return itemRepository.save(item);
  }

  public void updateQuantity(int itemId, int quantity) {
    Item item = itemRepository.findById(itemId).get();
    if ( item != null ) {
      item.setQuantity(quantity);
      itemRepository.save(item);
    }
  }

  public List<ItemDto> getItems() {
    List<Item> items = itemRepository.findAll();
    return items.stream()
            .map(itemMapper::itemToItemDto)
            .collect(Collectors.toList());
  }

  public void deleteItem(int itemId) {
    Item item = itemRepository.findById(itemId).get();
    itemRepository.deleteById(item.getId());
  }

}

// .get() de la clase Optional devuelve el valor si esta presente sino arrojará una excepción NoSuchElementException.
