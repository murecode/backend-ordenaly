package com.app.ordenaly.controllers;

import com.app.ordenaly.models.Ticket;
import com.app.ordenaly.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/ticket")
public class TicketController {
  @Autowired
  TicketService ticketService;

  @GetMapping(value = "/new-ticket")
  public Ticket newTicket(Ticket ticket) {
    return ticketService.generateTicket(ticket);

  }

}
