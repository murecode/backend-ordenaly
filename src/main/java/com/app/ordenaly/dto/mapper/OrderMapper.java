package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.model.Order;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface OrderMapper {

  @Mappings({
          @Mapping(source = "id", target = "orderId"),
          @Mapping(source = "ticket.id", target = "ticket"),
          @Mapping(source = "user.firstname", target = "waiter"),
          @Mapping(source = "orderStatus", target = "status")
  })
  OrderDto orderToOrderDto(Order order);

  @InheritInverseConfiguration
  Order orderDtoToOrder(OrderDto orderDto);

}
