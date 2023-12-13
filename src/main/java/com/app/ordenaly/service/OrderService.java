package com.app.ordenaly.service;

import com.app.ordenaly.model.User;
import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.OrderMapper;
import com.app.ordenaly.model.*;
import com.app.ordenaly.repository.*;
import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class OrderService {
  @Autowired
  OrderRepository orderRepository;
  @Autowired
  TicketRepository ticketRepository;
  @Autowired
  ItemRepository itemRepository;
  @Autowired
  ProductRepository productRepository;
  @Autowired
  UserRepository userRepository;
  @Autowired
  OrderMapper orderMapper;
  @Autowired
  ItemService itemService;


  public Order createOrder(int ticketId, int userId) {
    Ticket ticket = ticketRepository.findById(ticketId).get();
    User waiter = userRepository.findById(userId).get();

    if (ticket == null) { throw new EntityNotFoundException("Ticket no encontrado"); }
    if (waiter == null) { throw new EntityNotFoundException("User no encontrado"); }

    Order newOrder = new Order();
    newOrder.setTicket(ticket);
    newOrder.setUser(waiter);
    newOrder.setOrderStatus(OrderStatus.PENDIENTE);
    newOrder.setPaymentStatus(PaymentStatus.PENDIENTE);
    //Se asocia el id de la orden con el ticket
    ticket.setOrder(newOrder);
    Order saveOrder = orderRepository.save(newOrder);
    return saveOrder;
  }

  public Order addItemToOrder(int orderId, int productId, int quantity ) {
    Order order = orderRepository.findById(orderId).get();
    Product product = productRepository.findById(productId).get();

      Item item = new Item();
      item.setId(item.getId());
      item.setProduct(product);
      item.setQuantity(quantity);

      itemRepository.save(item);
      order.addItem(item);

    return orderRepository.save(order);
  }

  public OrderDto findOrderById(Integer id) {
    // 1. Buscar en la DB
    Order order = orderRepository.findById(id).orElse(null);
    // 2. Validar si existe
    if ( order != null) {
      // 3. Convertir la Entidad en un flujo
      Stream<Order> orderStream = Stream.of(order);
      // 4. Realizar la transformacion y recolectar el resultado en un Dto
      OrderDto orderDto = orderStream.map(orderMapper::orderToOrderDto)
              .findFirst() // Recoge el primer resultado (en este caso, el único)
              .orElse(null); // Devuelve null si no hay resultados
      return orderDto;
    }
    return null;
  }

  public List<OrderDto> getOrders() {
    List<Order> orders = orderRepository.findAll();
    return orders.stream()
            .map(orderMapper::orderToOrderDto)
            .collect(Collectors.toList());
  }

  public Order updateOrder(int id, Order order) {
    Order orderId = orderRepository.findById(id).get();
    order.setId(orderId.getId());
    return orderRepository.save(order);
  }

  public void deleteOrder(Integer id) {
    orderRepository.deleteById(id);
  }


}

// Doc

// Optional, clase Java que se utiliza para representar un valor que puede ser nulo o no nulo...
// verificando si un valor está presente o no antes de intentar acceder a él. Ayuda a evitar...
// las excepciones de tipo NullPointerException al acceder a un objeto que puede ser nulo.
