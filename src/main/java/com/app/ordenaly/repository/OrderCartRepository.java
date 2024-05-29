package com.app.ordenaly.repository;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.OrderCart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderCartRepository extends JpaRepository<OrderCart, Integer> {
  public List<OrderCart> findByOrder(Order order);

  // + deleteByOrderAndProduct(orderId, productId)
  // + updateQuantity(quantity, productId, orderId)
}
