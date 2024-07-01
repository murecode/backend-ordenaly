package com.app.ordenaly.controller;

import com.app.ordenaly.model.dtos.ticket.TicketCreateData;
import com.app.ordenaly.model.dtos.ticket.TicketData;
import com.app.ordenaly.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;

  @Operation(summary = "Listado de Tickets", description = "Retorna un arreglo con los Tickets")
  @GetMapping("")
  public ResponseEntity<Page<TicketData>> getAllTickets(Pageable pageable) {
    Page<TicketData> tickets = ticketService.findAllTickets(pageable);
    return ResponseEntity.ok(tickets);
  }

  @PostMapping("")
  public ResponseEntity<TicketData> createTicket(
          @RequestBody @Valid TicketCreateData ticketData) {
    TicketData ticket = ticketService.createTicket(ticketData);
    return new ResponseEntity<>(ticket, HttpStatus.CREATED);
  }

}
