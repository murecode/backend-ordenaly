package com.app.ordenaly.model.dtos;

import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.model.utils.TicketStatus;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalTime;

public record TicketData(
        int id,
        @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
        LocalTime createdAt,
        int numberOfPeople,
        TicketStatus status
) {
  public TicketData(Ticket ticket) {
    this(
            ticket.getId(),
            ticket.getCreatedAt(),
            ticket.getNumberOfPeople(),
            ticket.getStatus()
    );
  }

}
