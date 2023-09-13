package com.app.ordenaly.services;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.OrderItem;
import com.app.ordenaly.repositories.OrderItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderItemServiceImpl implements IOrderItemService {

  private final OrderItemRepository orderItemRepository;

  public OrderItemServiceImpl(OrderItemRepository orderItemRepository) {
    this.orderItemRepository = orderItemRepository;
  }

  public OrderItem findOrderItemById(Integer id) {
    return orderItemRepository.getOrderItemById(id);
  }

  @Override
  public List<OrderItem> findOrderItemsByOrder(Order id) {
    return null;
  }

//  public List<OrderItem> findOrderItemsByOrder(Order id) {
//    return orderItemRepository.getOrderItemsByOrder(id);
//  }
}
