package com.app.ordenaly.repository;

import com.app.ordenaly.model.Ticket;

import org.junit.jupiter.api.Test;
//import org.mockito.junit.jupiter.MockitoExtension;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import java.time.LocalTime;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.context.annotation.ConfigurationClassUtils.getOrder;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(value = false)
class TicketRepositoryTest {
  @Autowired
  TicketRepository ticketRepository;
  @Test
  void testGenerateTicket() {

    Ticket newTicket = new Ticket();
    newTicket.setTime(LocalTime.now());

    Ticket generate = ticketRepository.save(newTicket);

    assertTrue(generate.getId() > 0);

  }




}