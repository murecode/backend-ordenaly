package com.app.ordenaly.service;

import com.app.ordenaly.model.entity.Order;
import com.app.ordenaly.model.entity.OrderItem;
import com.app.ordenaly.presentation.request.OrderCartRequest;
import com.app.ordenaly.presentation.response.OrderItemData;
import com.app.ordenaly.model.entity.Product;
import com.app.ordenaly.repository.OrderItemRepository;
import com.app.ordenaly.repository.OrderRepository;
import com.app.ordenaly.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderItemService {
  @Autowired
  private OrderItemRepository orderCartRepo;
  @Autowired
  private ProductRepository productRepo;
  @Autowired
  private OrderRepository orderRepo;


  public List<OrderItemData> getCartByOrder(int orderId) {

    Optional<Order> order = orderRepo.findById(orderId);
    if (order.isEmpty()) {
      throw new IllegalArgumentException("Order cannot be null");
    }

    List<OrderItem> orderItem = orderCartRepo.findAllByOrder(order.get());

    return orderItem.stream().map(oc -> new OrderItemData(
            oc.getId(),
            oc.getProduct().getTitle(),
            oc.getQuantity(),
            oc.calculateSubtotal()
    )).collect(Collectors.toList());
  }

  public OrderItemData addProductToCart(int orderId, OrderCartRequest orderCartBody) {

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
    Optional<OrderItem> existingOrderCartOptional = orderCartRepo
            .findByOrderAndProduct(order, product);

    OrderItem orderItem;
    if (existingOrderCartOptional.isPresent()) {
      // Si el producto ya está en el carrito, sumar la cantidad
      orderItem = existingOrderCartOptional.get();
      orderItem.setQuantity(orderItem.getQuantity() + orderCartBody.getQuantity());
    } else {
      // Si el producto no está en el carrito, crear una nueva entrada
      orderItem = new OrderItem();
      orderItem.setOrder(order);
      orderItem.setProduct(product);
      orderItem.setQuantity(orderCartBody.getQuantity());
    }

    OrderItem oc = orderCartRepo.save(orderItem);

    return new OrderItemData(
            oc.getId(),
            oc.getProduct().getTitle(),
            oc.getQuantity(),
            oc.calculateSubtotal()
    );
  }

  public void deleteProductFromCart(int id) {
    orderCartRepo.deleteById(id);
  }

  public OrderItemData updateQuantity(int orderCartId, OrderCartRequest orderCartBody) {
    Optional<OrderItem> orderCart = orderCartRepo.findById(orderCartId);

    if (orderCartBody.getQuantity() != 0) {
      orderCart.get().setQuantity(orderCartBody.getQuantity());
    }

    OrderItem oc = orderCartRepo.save(orderCart.get());

    return new OrderItemData(
            oc.getId(),
            oc.getProduct().getTitle(),
            oc.getQuantity(),
            oc.calculateSubtotal()
    );
  }

}
