package com.app.ordenaly.service;

import com.app.ordenaly.model.Item;
import com.app.ordenaly.model.Product;
import com.app.ordenaly.repository.ItemRepository;
import com.app.ordenaly.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemService {
  @Autowired
  ItemRepository itemRepository;
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

}

// .get() de la clase Optional devuelve el valor si esta presente sino arrojará una excepción NoSuchElementException.
