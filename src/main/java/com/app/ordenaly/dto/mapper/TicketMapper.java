package com.app.ordenaly.dto.mapper;

import com.app.ordenaly.dto.TicketDto;
import com.app.ordenaly.model.Ticket;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TicketMapper {

  @Mappings({
          @Mapping(source = "id", target = "ticket_id"),
          @Mapping(source = "time", target = "created_at", dateFormat = "hh:mm:ss a"),
          @Mapping(source = "order.id", target = "related_order")
  })
  TicketDto ticketToTicketDto(Ticket ticket);
  @InheritInverseConfiguration
  Ticket ticketDtoToTicket(TicketDto ticketDto);
  List<TicketDto> ticketsDto(List<Ticket> ticketList);

}
