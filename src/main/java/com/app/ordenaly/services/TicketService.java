package com.app.ordenaly.services;

import com.app.ordenaly.models.Ticket;
import com.app.ordenaly.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;

@Service
public class TicketService {
  @Autowired
  private TicketRepository ticketRepo;


  public List<Ticket> getAllTickets() {
    return ticketRepo.findAll();
  }

  public Ticket generateNewTicket() {
    Ticket ticket = new Ticket();
    ticket.setTime(LocalTime.now());
    return ticketRepo.save(ticket);
  }

}
