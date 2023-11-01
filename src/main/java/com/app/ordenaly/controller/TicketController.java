package com.app.ordenaly.controller;

import com.app.ordenaly.dto.TicketDto;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;

  @GetMapping("/list")
  public List<TicketDto> listAllTickets() {
    return ticketService.getAllTickets();
  }

  @PostMapping("/new")
  public Ticket newTicket(Ticket ticket) {
    return ticketService.generateNewTicket();
  }

}
