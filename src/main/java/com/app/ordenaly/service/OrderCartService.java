package com.app.ordenaly.service;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.OrderCart;
import com.app.ordenaly.model.Product;
import com.app.ordenaly.repository.OrderCartRepository;
import com.app.ordenaly.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderCartService {
  @Autowired
  private OrderCartRepository orderCartRepo;
  @Autowired
  private ProductRepository productRepo;

  public List<OrderCart> listOrderCart(Order order) {
    return orderCartRepo.findByOrder(order);
  }

  public int addProductToCart(Integer productId, int quantity, Order order) {
    int addedQuantity = quantity;

    Product product = productRepo.findById(productId).get();
    OrderCart orderCartItem = orderCartRepo.findByOrderAndProduct(order, product);

    if (orderCartItem != null) {
      addedQuantity = orderCartItem.getQuantity() + quantity;
      orderCartItem.setQuantity(addedQuantity);
    } else {
      orderCartItem = new OrderCart();
      orderCartItem.setOrder(order);
      orderCartItem.setProduct(product);
      orderCartItem.setQuantity(quantity);
    }

    orderCartRepo.save(orderCartItem);

    return addedQuantity;
  }

  // +removeProduct(productId, order)
  // +updateQuantity(productId, quantity, order)

}
