package com.app.ordenaly.controllers;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.mapper.OrderMapper;
import com.app.ordenaly.models.Order;
import com.app.ordenaly.repositories.OrderRepository;
import com.app.ordenaly.services.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
  @Autowired
  OrderService orderService;
  @Autowired
  OrderMapper orderMapper;
  @Autowired
  OrderRepository orderRepository;

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

  @PostMapping("")
  public ResponseEntity<OrderDto> newOrder(
          @RequestBody OrderDto orderDto) {
    Order order = orderMapper.orderDtoToOrder( orderDto );
    orderService.createOrder( order );

   /* if(order.getTicket() == null || order.getUser() == null) {
      return new ResponseEntity<OrderDto>(HttpStatus.BAD_REQUEST );
    }*/
    // TODO: "Manejar exopciones"
    return new ResponseEntity<OrderDto>(orderDto, HttpStatus.CREATED);
  }


  @PostMapping("/{order-id}/{product-id}/item")
  public ResponseEntity<String> addItemToOrder(
          @PathVariable("order-id") int orderId,
          @PathVariable("product-id") int productId) {
    orderService.addItemToOrder(orderId, productId);
    return ResponseEntity.ok("Item agregado al pedido");
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateOrderStatus(
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
  public ResponseEntity<String> removeOrder(@PathVariable("id") Integer id) {
    orderService.deleteOrder(id);
    return new ResponseEntity<>("Orden Eliminada", HttpStatus.OK );
  }

}

//DOC

/* Model, es un objeto que se utiliza para transportar datos entre el controlador y la vista. */
