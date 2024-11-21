package com.app.ordenaly.controller;

import com.app.ordenaly.model.enums.TicketStatus;
import com.app.ordenaly.presentation.request.TicketRequest;
import com.app.ordenaly.presentation.response.TicketData;
import com.app.ordenaly.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
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
  public ResponseEntity<Page<TicketData>> getAllTickets(
          @PageableDefault(
                  page = 0,
                  size = 20,
                  sort = {"id"},
                  direction = Sort.Direction.ASC)
          Pageable pageable) {
    Page<TicketData> tickets = ticketService.findAllTickets(pageable);
    return ResponseEntity.ok(tickets);
  }

  @GetMapping("/status/{status}")
  public ResponseEntity<Page<TicketData>> getAllTicketsByStatus(
          @PathVariable("status") TicketStatus status,
          @PageableDefault(
                  page = 0,
                  size = 15,
                  sort = {"createdAt"},
                  direction = Sort.Direction.ASC)
          Pageable pageable ) {
    Page<TicketData> tickets = ticketService.findAllTicketsByStatus(status, pageable);
    return ResponseEntity.ok(tickets);
  }

  @PostMapping("")
  public ResponseEntity<TicketData> createTicket(
          @RequestBody @Valid TicketRequest ticketData) {
    TicketData ticket = ticketService.createTicket(ticketData);
    return new ResponseEntity<>(ticket, HttpStatus.CREATED);
  }

  // Actualizar estado del ticket

}
