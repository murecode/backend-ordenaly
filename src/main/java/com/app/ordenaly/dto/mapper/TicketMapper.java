package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.OrderDto;
import com.app.ordenaly.dto.TicketDto;
import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.Ticket;
import org.mapstruct.*;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {

  @Mappings({
          @Mapping(source = "id", target = "id"),
          @Mapping(source = "time", target = "hora"),
          @Mapping(source = "order.id", target = "orden")
  })
  TicketDto ticketToTicketDto(Ticket ticket);
  @InheritInverseConfiguration
  Ticket ticketDtoToTicket(OrderDto orderDto);

}
