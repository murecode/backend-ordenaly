package com.app.ordenaly.controller;

import com.app.ordenaly.dto.TicketDto;
//import com.app.ordenaly.model.Order;
import com.app.ordenaly.dto.mapper.TicketMapper;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.service.OrderService;
import com.app.ordenaly.service.TicketService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
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
  @Autowired
  TicketMapper ticketMapper;

  @Operation(summary = "Listado de Tickets", description = "Retorna un arreglo con los Tickets")
  @GetMapping("")
  public ResponseEntity<List<TicketDto>> listAllTickets() {
    List<Ticket> tickets = ticketService.getAllTickets();
    List<TicketDto> ticketDto = ticketMapper.ticketsDto( tickets );
    return new ResponseEntity<>(ticketDto, HttpStatus.OK);
  }

  @PostMapping("")
  public ResponseEntity<TicketDto> newTicket() {
    Ticket ticket = ticketService.generateTicket();
    TicketDto ticketDto = ticketMapper.ticketToTicketDto( ticket );
    return new ResponseEntity<>(ticketDto, HttpStatus.CREATED);
  }

}
