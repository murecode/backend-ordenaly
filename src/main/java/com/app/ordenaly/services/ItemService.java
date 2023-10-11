package com.app.ordenaly.services;

import com.app.ordenaly.models.Item;
import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.Product;
import com.app.ordenaly.repositories.ItemRepository;
import com.app.ordenaly.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemService {
  @Autowired
  ItemRepository itemRepository;

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
