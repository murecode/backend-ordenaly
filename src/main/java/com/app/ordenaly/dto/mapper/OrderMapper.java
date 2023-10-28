package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.model.Order;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ItemMapper.class, TicketMapper.class}
)
public interface OrderMapper {

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "ticket.id", target = "turno"),
          @Mapping(source = "user.firstname", target = "mesero"),
          @Mapping(source = "orderStatus", target = "estado"),
          @Mapping(source = "itemList", target = "pedido"),

  })
  OrderDto orderToOrderDto(Order order);
  @InheritInverseConfiguration
  Order orderDtoToOrder(OrderDto orderDto);

  //De una lista de Order a una lista de OrderDto
  List<OrderDto> orderDtoList(List<Order> orderList);

}
