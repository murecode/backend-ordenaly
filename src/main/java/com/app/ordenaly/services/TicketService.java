package com.app.ordenaly.services;

//import com.app.ordenaly.dto.mapper.TicketMapper;
import com.app.ordenaly.models.Ticket;
import com.app.ordenaly.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class TicketService {
  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
//  private TicketMapper ticketMapper;

  public List<Ticket> getAllTickets() {
    return ticketRepository.findAll();
  }

  public Ticket generateTicket() {
    Ticket ticket = new Ticket();
    ticket.setTime(LocalTime.now());
    ticket.setOrder(ticket.getOrder());
    return ticketRepository.save( ticket );
  }

  public Ticket getTicketById(int id) {
    return ticketRepository.findById(id).get();
  }

}
