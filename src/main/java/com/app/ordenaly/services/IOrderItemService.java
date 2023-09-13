package com.app.ordenaly.services;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.OrderItem;

import java.util.List;

public interface IOrderItemService {

  OrderItem findOrderItemById(OrderItem id);

  List<OrderItem> findOrderItemsByOrder(Order id);

}
