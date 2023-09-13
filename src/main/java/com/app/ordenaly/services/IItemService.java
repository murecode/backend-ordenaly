package com.app.ordenaly.services;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.Item;

import java.util.List;

public interface IItemService {

  Item findItemById(Integer id);

  List<Item> listItemsByOrder(Order id);

}
