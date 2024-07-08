package com.app.ordenaly.service;

import com.app.ordenaly.model.entities.Order;
import com.app.ordenaly.model.entities.OrderCart;
import com.app.ordenaly.model.request.CreateOrderCart;
import com.app.ordenaly.model.response.OrderCartData;
import com.app.ordenaly.model.entities.Product;
import com.app.ordenaly.infra.repository.OrderCartRepository;
import com.app.ordenaly.infra.repository.OrderRepository;
import com.app.ordenaly.infra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderCartService {
  @Autowired
  private OrderCartRepository orderCartRepo;
  @Autowired
  private ProductRepository productRepo;
  @Autowired
  private OrderRepository orderRepo;


  public List<OrderCartData> getCartByOrder(int orderId) {

    Optional<Order> order = orderRepo.findById(orderId);
    if (order.isEmpty()) {
      throw new IllegalArgumentException("Order cannot be null");
    }

    List<OrderCart> orderCart = orderCartRepo.findAllByOrder(order.get());

    return orderCart.stream().map(oc -> new OrderCartData(
            oc.getId(),
            oc.getProduct().getTitle(),
            oc.getQuantity(),
            oc.calculateSubtotal()
    )).collect(Collectors.toList());
  }

  public OrderCartData addProductToCart(int orderId, CreateOrderCart orderCartBody) {

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
            oc.getId(),
            oc.getProduct().getTitle(),
            oc.getQuantity(),
            oc.calculateSubtotal()
    );
  }

  public void deleteProductFromCart(int id) {
    orderCartRepo.deleteById(id);
  }

  // +updateQuantity(productId, quantity, order)

}
