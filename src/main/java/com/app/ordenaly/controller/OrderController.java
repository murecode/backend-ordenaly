package com.app.ordenaly.controller;

//import com.app.ordenaly.models.dto.mapper.OrderMapper;
import com.app.ordenaly.model.OrderDto;
import com.app.ordenaly.repository.OrderRepository;
import com.app.ordenaly.service.OrderService;
        import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/orders")
public class OrderController {
  @Autowired
  OrderService orderService;
//  @Autowired
//  OrderMapper orderMapper;
  @Autowired
  OrderRepository orderRepository;

  @GetMapping("")
/*  public List<OrderDto> getOrders() {
    return orderMapper.ordersDto(orderService.getOrders());
  }*/

 /* @Operation(summary = "Obtiene una Orden por su ID", description = "Retorna una orden especifica")
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
  }*/

  /*@PostMapping("")
  public ResponseEntity<OrderDto> newOrder(
          @RequestBody OrderDto orderDto) {
    orderService.createOrder( orderDto );

    // TODO: "Manejar exepciones"

    return new ResponseEntity<OrderDto>(orderDto, HttpStatus.CREATED);
  }*/

  @PostMapping("/{order-id}")
  public ResponseEntity<String> addItemToOrder(
          @PathVariable("order-id") int orderId,
          @RequestParam("product") int productId) {
    orderService.addItemToOrder(orderId, productId);
    // TODO: "Manejar exepciones"
    return ResponseEntity.ok("Item agregado al pedido");
  }

  @DeleteMapping("/item/{item-id}")
  public ResponseEntity<String> deleteOrderItem(
          @PathVariable("item-id") int itemId){
    orderService.deleteOrderItem(itemId);
    // TODO: "Manejar exepciones"
    return new ResponseEntity<>("Item eliminado" + itemId, HttpStatus.ACCEPTED);
  }

  /*@PutMapping("/{id}")
  public ResponseEntity<String> updateOrder(
          @PathVariable("id") int orderId,
          @RequestBody OrderDto orderDto ) {
    Order orderBody = orderMapper.orderDtoToOrder( orderDto );
    orderService.updateOrder( orderId, orderBody );
    if ( orderBody.getId() != null ) {
      return new ResponseEntity<>("Orden Actualizada", HttpStatus.OK);
    }
    return new ResponseEntity<>("No se encontrol la orden", HttpStatus.BAD_REQUEST);
  }*/

  @DeleteMapping("/{id}")
  public ResponseEntity<String> removeOrder(@PathVariable("id") Integer id) {
    orderService.deleteOrder(id);
    return new ResponseEntity<>("Orden Eliminada", HttpStatus.OK );
  }

}

//DOC

/* Model, es un objeto que se utiliza para transportar datos entre el controlador y la vista. */
