package com.app.ordenaly.service;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.OrderCart;
import com.app.ordenaly.model.dtos.orderCart.OrderCartCreateData;
import com.app.ordenaly.model.dtos.orderCart.OrderCartData;
import com.app.ordenaly.model.Product;
import com.app.ordenaly.infra.repository.OrderCartRepository;
import com.app.ordenaly.infra.repository.OrderRepository;
import com.app.ordenaly.infra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

  public OrderCartData addProductToCart(int orderId, OrderCartCreateData orderCartBody) {

    Optional<Order> orderOptional = orderRepo.findById(orderId);
    if (orderOptional.isEmpty()) {
      throw new IllegalArgumentException("Order cannot be null");
    }
    Order order = orderOptional.get();

    Optional<Product> productOptional = productRepo.findById(orderCartBody.getProduct());
    if (productOptional.isEmpty()) {
      throw new IllegalArgumentException("Product cannot be null");
    }
    Product product = productOptional.get();

    // Verificar si el producto ya está en el carrito de la orden
    Optional<OrderCart> existingOrderCartOptional = orderCartRepo
            .findByOrderAndProduct(order, product);

    OrderCart orderCart;
    if (existingOrderCartOptional.isPresent()) {
      // Si el producto ya está en el carrito, sumar la cantidad
      orderCart = existingOrderCartOptional.get();
      orderCart.setQuantity(orderCart.getQuantity() + orderCartBody.getQuantity());
    } else {
      // Si el producto no está en el carrito, crear una nueva entrada
      orderCart = new OrderCart();
      orderCart.setOrder(order);
      orderCart.setProduct(product);
      orderCart.setQuantity(orderCartBody.getQuantity());
    }

    OrderCart oc = orderCartRepo.save(orderCart);

    return new OrderCartData(
            oc.getProduct().getTitle(),
            oc.getQuantity(),
            oc.calculateSubtotal()
    );
  }

  // +removeProduct(productId, order)
  // +updateQuantity(productId, quantity, order)

}
