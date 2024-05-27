//package com.app.ordenaly.dto.mapper;
//
//import com.app.ordenaly.dto.OrderDto;
//import com.app.ordenaly.models.Order;
//import org.mapstruct.*;
//
//import java.util.List;
//
//@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
//public interface OrderMapper {
//
//  @Mappings({
//          @Mapping(source = "id",            target = "id"),
//          @Mapping(source = "ticket.id",     target = "ticket"),
////          @Mapping(source = "user.fullname", target = "waiter"),
//          @Mapping(source = "table",         target = "table"),
//          @Mapping(source = "orderStatus",   target = "orderStatus"),
//          @Mapping(source = "paymentStatus", target = "paymentStatus"),
//          @Mapping(source = "notes",         target = "orderComment")
//  })
//
//  OrderDto orderToOrderDto(Order order);
//  @InheritInverseConfiguration
//  Order orderDtoToOrder(OrderDto orderDto);
//
//  //De una lista de Order a una lista de OrderDto
//  List<OrderDto> ordersDto(List<Order> orderList);
//
//}
