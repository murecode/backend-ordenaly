package com.app.ordenaly.repositories;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.OrderItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {

//  public List<OrderItem> getOrderItemsByOrder(Order id);

  OrderItem getOrderItemById(OrderItem id);

}
