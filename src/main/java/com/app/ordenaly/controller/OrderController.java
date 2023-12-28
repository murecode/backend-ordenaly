package com.app.ordenaly.controller;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.OrderMapper;
import com.app.ordenaly.model.Order;
import com.app.ordenaly.service.OrderService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/orders")
public class OrderController {
  @Autowired
  OrderService orderService;
  @Autowired
  OrderMapper orderMapper;


  @GetMapping("")
  public List<OrderDto> getOrders() {
    List<Order> orders = orderService.getOrders();
    List<OrderDto> ordersDto = orderMapper.ordersDto( orders );
    return ordersDto;
  }

  @GetMapping("/{id}")
  public ResponseEntity<OrderDto> getOrder(
          @PathVariable("id") int orderId) {
    Order order = orderService.findOrderById( orderId );
    OrderDto orderDto = orderMapper.orderToOrderDto( order );
    if (order != null) {
      return ResponseEntity.ok(orderDto);
    } else {
      return ResponseEntity.notFound().build();
    }
  }

  @PostMapping("")
  public ResponseEntity<String> newOrder(
          @RequestParam("ticketId") int ticketId,
          @RequestParam("userId") int userId) {
    Order order = orderService.createOrder( ticketId, userId );

    if(order.getTicket() == null || order.getUser() == null) {
      return new ResponseEntity<>("Ticket o Mesero deben ser validos", HttpStatus.BAD_REQUEST );
    }
    return new ResponseEntity<>("Orden Creada", HttpStatus.CREATED);
  }

  @PostMapping("/{id}/add-item")
  public ResponseEntity<String> addItemToOrder(
          @PathVariable("id") int orderId,
          @RequestParam(name = "productId") int productId) {
    orderService.addItemToOrder(orderId, productId);
    return ResponseEntity.ok("Item agregado al pedido");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateOrder(
          @PathVariable("id") int orderId,
          @RequestBody OrderDto orderDto ) {
    Order orderBody = orderMapper.orderDtoToOrder( orderDto );
    orderService.updateOrder( orderId, orderBody );
    if ( orderBody.getId() != null ) {
      return new ResponseEntity<>("Orden Actualizada", HttpStatus.OK);
    }
    return new ResponseEntity<>("No se encontrol la orden", HttpStatus.BAD_REQUEST);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> removeOrder(@PathVariable("id") Integer id) {
    orderService.deleteOrder(id);
    return new ResponseEntity<>( HttpStatus.OK );
  }

}

