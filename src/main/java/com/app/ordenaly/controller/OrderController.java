package com.app.ordenaly.controller;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.OrderMapper;
import com.app.ordenaly.model.Order;
import com.app.ordenaly.service.OrderService;
import io.swagger.v3.oas.annotations.Operation;
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
@RequestMapping("/api/v1/orders")
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

  @Operation(summary = "Obtiene una Orden por su ID", description = "Retorna una orden especifica")
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

//  @PostMapping("")
//  public ResponseEntity<OrderDto> newOrder(
//          @RequestParam("ticketId") int ticketId,
//          @RequestParam("userId") int userId) {
//    Order order = orderService.createOrder( ticketId, userId );
//    OrderDto orderDto = orderMapper.orderToOrderDto( order );
//
//    if(order.getTicket() == null || order.getUser() == null) {
//      return new ResponseEntity<OrderDto>(HttpStatus.BAD_REQUEST );
//    }
//    return new ResponseEntity<OrderDto>(orderDto, HttpStatus.CREATED);
//  }

  @PostMapping("")
  public ResponseEntity<OrderDto> newOrder(
          @RequestBody OrderDto orderDto) {
    Order order = orderMapper.orderDtoToOrder( orderDto );
    orderService.createOrder( order );

    if(order.getTicket() == null || order.getUser() == null) {
      return new ResponseEntity<OrderDto>(HttpStatus.BAD_REQUEST );
    }
    return new ResponseEntity<OrderDto>(orderDto, HttpStatus.CREATED);
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
    orderService.updateOrderStatus( orderId, orderBody );
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

