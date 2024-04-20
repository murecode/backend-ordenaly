package com.app.ordenaly.controllers;

import com.app.ordenaly.models.Ticket;
import com.app.ordenaly.services.OrderService;
import com.app.ordenaly.services.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;
  @Autowired
  OrderService orderService;

  @Operation(summary = "Listado de Tickets", description = "Retorna un arreglo con los Tickets")
  @GetMapping("")
  public ResponseEntity<List<Ticket>> listAllTickets() {
    List<Ticket> tickets = ticketService.getAllTickets();
    return new ResponseEntity<>(tickets, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<Ticket> newTicket() {
    Ticket ticket = ticketService.generateTicket();
    return new ResponseEntity<>(ticket, HttpStatus.CREATED);
  }

}
