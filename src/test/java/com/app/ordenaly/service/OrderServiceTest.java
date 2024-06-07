package com.app.ordenaly.service;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.model.dto.OrderRequest;
import com.app.ordenaly.repository.OrderRepository;
import com.app.ordenaly.repository.TicketRepository;
import com.app.ordenaly.repository.UserRepository;
import com.app.ordenaly.infra.security.model.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.verify;

@SpringBootTest
class OrderServiceTest {
  @Autowired
  OrderService orderService;
  @Mock
  private TicketRepository ticketRepo;
  @Mock
  private UserRepository userRepo;
  @Mock
  private OrderRepository orderRepo;

  @BeforeEach
  void setUp() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testCreateOrder_success() {
    // Datos de prueba
    Ticket ticket = new Ticket();
    ticket.setId(10);
    User waiter = new User();
    waiter.setId(3);
    OrderRequest orderRequest = new OrderRequest(ticket.getId(), waiter.getId());

    // Configuración de los mocks
    Mockito.when(ticketRepo.findById(anyInt())).thenReturn(Optional.of(ticket));
    Mockito.when(userRepo.findById(anyInt())).thenReturn(Optional.of(waiter));
    Mockito.when(orderRepo.save(any(Order.class))).thenReturn(new Order());

    // Llamada al método a probar
    Order order = orderService.createOrder(orderRequest);

    // Verificaciones
    assertNotNull(order);
    verify(ticketRepo).findById(orderRequest.getTicket());
    verify(userRepo).findById(orderRequest.getWaiter());
    verify(orderRepo).save(any(Order.class));
  }

}