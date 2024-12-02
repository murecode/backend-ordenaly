package com.app.ordenaly.service;

import com.app.ordenaly.model.entity.Ticket;
import com.app.ordenaly.presentation.advice.exception.ticket_exception.NumberOfPeopleException;
import com.app.ordenaly.presentation.response.TicketStatisticsData;
import com.app.ordenaly.repository.TicketRepository;
import com.app.ordenaly.presentation.request.TicketRequest;
import com.app.ordenaly.presentation.response.TicketData;
import com.app.ordenaly.model.enums.TicketStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class TicketService {
  @Autowired
  private TicketRepository ticketRepo;

  public Page<TicketData> findAllTickets(Pageable pageable) {
    return ticketRepo.findAll(pageable).map(TicketData::new);
  }

  public Page<TicketData> findAllTicketsByStatus(
          TicketStatus status, Pageable pageable) {
    return ticketRepo.findByStatus(status, pageable).map(TicketData::new);
  }

  public TicketData createTicket(TicketRequest ticketData) {

    if( ticketData.getNumberOfPeople() < 1 ) {
      throw new NumberOfPeopleException("Valor no valido, solo enteros positivos");
    }
    if( ticketData.getNumberOfPeople() > 12 ) {
      throw new NumberOfPeopleException("Valor no valido, número de comensales excesivo por ticket");
    }

    Ticket ticket = new Ticket();
    ticket.setCreatedAt(LocalTime.now());
    ticket.setCreatedDate(LocalDate.now());
    ticket.setNumberOfPeople(ticketData.getNumberOfPeople());
    ticket.setStatus(TicketStatus.WAITING);

    Ticket t = ticketRepo.save(ticket);

    return new TicketData(
            t.getId(),
            t.getCreatedAt(),
            t.getCreatedDate(),
            t.getNumberOfPeople(),
            t.getStatus()
    );
  }

  public void updateTicketStatus() {
    // cancelado: cuando pasan mas de 30 min sin ser atendido y haber generado una orden
  }

  public Map<String, Long> getTicketStatistics() {
    return ticketRepo.findTicketStatistics()
            .stream()
            .collect(Collectors.toMap(
                    TicketStatisticsData::status,
                    TicketStatisticsData::quantity
            ));
  }





}
