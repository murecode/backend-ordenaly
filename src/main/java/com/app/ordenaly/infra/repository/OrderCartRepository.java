package com.app.ordenaly.infra.repository;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.OrderCart;
import com.app.ordenaly.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderCartRepository extends JpaRepository<OrderCart, Integer> {
  Optional<OrderCart> findByOrder(Order order);
  Optional<OrderCart> findByOrderAndProduct(Order order, Product product);


  // + deleteByOrderAndProduct(orderId, productId)
  // + updateQuantity(quantity, productId, orderId)
}
