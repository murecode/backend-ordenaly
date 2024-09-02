package com.app.ordenaly.infra.repository;

import com.app.ordenaly.model.entities.Ticket;

import com.app.ordenaly.model.enums.TicketStatus;
import jakarta.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalTime;

import static org.springframework.context.annotation.ConfigurationClassUtils.getOrder;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class TicketRepositoryTest {
  @Autowired
  private TicketRepository ticketRepository;
  @Autowired
  private EntityManager entityManager;

  @Test
  void testGenerateTicket() {

    Ticket newTicket = new Ticket();
    newTicket.setCreatedAt(LocalTime.now());
    newTicket.setNumberOfPeople(6);
    newTicket.setStatus(TicketStatus.WAITING);

    Ticket generate = ticketRepository.save(newTicket);

  }

 /* @Test
  void testFindTicketById() {
    Ticket ticket = entityManager.find(Ticket.class, 17);

    assertTrue(ticket.getId() == 17);
  }*/




}