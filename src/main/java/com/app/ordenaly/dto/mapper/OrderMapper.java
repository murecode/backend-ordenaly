package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.model.Order;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = {ItemMapper.class}
)
public interface OrderMapper {

  @Mappings({
          @Mapping(source = "id", target = "order"),
          @Mapping(source = "ticket.id", target = "turno"),
          @Mapping(source = "user.firstname", target = "mesero"),
          @Mapping(source = "orderStatus", target = "estado"),
          @Mapping(source = "itemList", target = "pedido")
  })
  OrderDto orderToOrderDto(Order order);

  @InheritInverseConfiguration
  Order orderDtoToOrder(OrderDto orderDto);

}
