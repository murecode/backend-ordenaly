package com.app.ordenaly.services;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.Item;
import com.app.ordenaly.repositories.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements IItemService {

  private final ItemRepository orderItemRepository;

  public OrderItemServiceImpl(ItemRepository orderItemRepository) {
    this.orderItemRepository = orderItemRepository;
  }

  public Item findOrderItemById(Integer id) {
    return orderItemRepository.getOrderItemById(id);
  }

  @Override
  public List<Item> findOrderItemsByOrder(Order id) {
    return null;
  }

//  public List<OrderItem> findOrderItemsByOrder(Order id) {
//    return orderItemRepository.getOrderItemsByOrder(id);
//  }
}
