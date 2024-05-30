package com.app.ordenaly.service;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.OrderCart;
import com.app.ordenaly.model.OrderCartData;
import com.app.ordenaly.model.Product;
import com.app.ordenaly.repository.OrderCartRepository;
import com.app.ordenaly.repository.OrderRepository;
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
  @Autowired
  private OrderRepository orderRepo;

  public List<OrderCartData> getCartByOrder(int orderId) {
    Order order = orderRepo.findById(orderId).orElse(null);

    List<OrderCartData> cartList = orderCartRepo.findById(orderId).stream()
            .map(OrderCartData::new).toList();

    return cartList;
  }

  public int addProductToCart(Integer productId, int quantity, Order order) {
    int addedQuantity = quantity;

    Product product = productRepo.findById(productId).get();
    OrderCart orderCart = orderCartRepo.findByOrderAndProduct(order, product);

    if (orderCart != null) {
      addedQuantity = orderCart.getQuantity() + quantity;
      orderCart.setQuantity(addedQuantity);
    } else {
      orderCart = new OrderCart();
      orderCart.setOrder(order);
      orderCart.setProduct(product);
      orderCart.setQuantity(quantity);
    }

    orderCartRepo.save(orderCart);

    return addedQuantity;
  }

  // +removeProduct(productId, order)
  // +updateQuantity(productId, quantity, order)

}
