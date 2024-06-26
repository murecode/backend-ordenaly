package com.app.ordenaly.controller;

import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.model.dtos.TicketCreateData;
import com.app.ordenaly.model.dtos.TicketData;
import com.app.ordenaly.service.OrderService;
import com.app.ordenaly.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;

  @Operation(summary = "Listado de Tickets", description = "Retorna un arreglo con los Tickets")
  @GetMapping("")
  public ResponseEntity<List<Ticket>> listAllTickets() {
    List<Ticket> tickets = ticketService.getAllTickets();
    return new ResponseEntity<>(tickets, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<TicketData> createTicket(
          @RequestBody @Valid TicketCreateData ticketData) {
    TicketData ticket = ticketService.createTicket(ticketData);
    return new ResponseEntity<>(ticket, HttpStatus.CREATED);
  }

}
