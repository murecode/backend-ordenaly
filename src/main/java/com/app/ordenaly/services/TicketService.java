package com.app.ordenaly.services;

import com.app.ordenaly.models.Ticket;
import com.app.ordenaly.repositories.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TicketService {
  @Autowired
  private TicketRepository ticketRepo;

  public Ticket generateTicket(Ticket ticket) {
    return ticketRepo.save(ticket);
  }

  public List<Ticket> getAllTickets() {
    return ticketRepo.findAll();
  }

}
