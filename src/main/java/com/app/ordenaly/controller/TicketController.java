package com.app.ordenaly.controller;

import com.app.ordenaly.dto.TicketDto;
//import com.app.ordenaly.model.Order;
import com.app.ordenaly.dto.mapper.TicketMapper;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.service.OrderService;
import com.app.ordenaly.service.TicketService;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/tickets")
public class TicketController {
  @Autowired
  TicketService ticketService;
  @Autowired
  OrderService orderService;
  @Autowired
  TicketMapper ticketMapper;

  @GetMapping("")
  public List<TicketDto> listAllTickets() {
    return ticketService.getAllTickets();
  }

  @PostMapping("")
  public ResponseEntity<TicketDto> newTicket(
          @RequestBody Ticket ticketBody) {
    Ticket ticket = ticketService.generateTicket( ticketBody );
    TicketDto ticketDto = ticketMapper.ticketToTicketDto(ticket);
    return new ResponseEntity<>(ticketDto, HttpStatus.CREATED);
  }

//  @PostMapping("/take")
//  public ResponseEntity<String> takeOrder(
//          @PathVariable int ticketId, @PathVariable int waiterId) {
//    try {
//      orderService.createOrder(ticketId, waiterId);
//      return new ResponseEntity<>("Orden tomada", HttpStatus.CREATED);
//    } catch (EntityNotFoundException e) {
//      return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
//    } catch (Exception e) {
//      return new ResponseEntity<>("Error creating order", HttpStatus.INTERNAL_SERVER_ERROR);
//    }
//  }

}
