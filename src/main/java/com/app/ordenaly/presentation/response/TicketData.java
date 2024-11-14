package com.app.ordenaly.presentation.response;

import com.app.ordenaly.model.entity.Ticket;
import com.app.ordenaly.model.enums.TicketStatus;
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
