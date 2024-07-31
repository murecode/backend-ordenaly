package com.app.ordenaly.infra.repository;

import com.app.ordenaly.model.entities.Order;
import com.app.ordenaly.model.entities.OrderItem;
import com.app.ordenaly.model.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderItemRepository extends JpaRepository<OrderItem, Integer> {
  Optional<OrderItem> findByOrderAndProduct(Order order, Product product);

  @Query("SELECT oi FROM OrderItem oi WHERE oi.order = :orderId")
  List<OrderItem> findAllByOrder(@Param("orderId") Order order);

}
