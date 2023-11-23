package com.app.ordenaly.controller;

import com.app.ordenaly.dto.TicketDto;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;

  @GetMapping("/list")
  public List<TicketDto> listAllTickets() {
    return ticketService.getAllTickets();
  }

  @PostMapping("/new")
  public ResponseEntity<Ticket> newTicket(Ticket ticket) {
    Ticket newTicket= ticketService.generateNewTicket();
    return new ResponseEntity<>(newTicket, HttpStatus.CREATED);
  }

}
