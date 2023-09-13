package com.app.ordenaly.services;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.Item;
import com.app.ordenaly.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemServiceImpl implements IItemService {

  private final ItemRepository itemRepository;

  public ItemServiceImpl(ItemRepository itemRepository) {
    this.itemRepository = itemRepository;
  }

  public Item findItemById(Integer id) {
    return itemRepository.getItemById(id);
  }

  public List<Item> listItemsByOrder(Order id) {
    return null;
  }

//  public List<OrderItem> findOrderItemsByOrder(Order id) {
//    return orderItemRepository.getOrderItemsByOrder(id);
//  }
}
