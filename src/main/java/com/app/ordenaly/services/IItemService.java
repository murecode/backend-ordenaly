package com.app.ordenaly.services;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.Item;

import java.util.List;

public interface IItemService {

  Item findOrderItemById(Integer id);

  List<Item> findOrderItemsByOrder(Order id);

}
