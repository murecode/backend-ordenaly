package com.app.ordenaly.infra.repository;

import com.app.ordenaly.model.entities.Order;
import com.app.ordenaly.model.entities.OrderCart;
import com.app.ordenaly.model.entities.Product;
import com.app.ordenaly.model.response.OrderCartData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrderCartRepository extends JpaRepository<OrderCart, Integer> {
//  List<OrderCartData> findByOrder(int order);
  Optional<OrderCart> findByOrderAndProduct(Order order, Product product);

}
