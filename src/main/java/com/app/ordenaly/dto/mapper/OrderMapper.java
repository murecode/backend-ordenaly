package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.models.Order;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING,
        uses = { UserMapper.class }
)
public interface OrderMapper {

  @Mappings({
          @Mapping(source = "id",            target = "order_id"),
          @Mapping(source = "ticket.id",     target = "related_ticket"),
          @Mapping(source = "user.fullname", target = "related_waiter"),
          @Mapping(source = "table",         target = "related_table"),
          @Mapping(source = "orderStatus",   target = "order_status"),
          @Mapping(source = "paymentStatus", target = "payment_status"),
          @Mapping(source = "notes",         target = "order_comment")
  })

  OrderDto orderToOrderDto(Order order);
  @InheritInverseConfiguration
  Order orderDtoToOrder(OrderDto orderDto);

  //De una lista de Order a una lista de OrderDto
  List<OrderDto> ordersDto(List<Order> orderList);

}
