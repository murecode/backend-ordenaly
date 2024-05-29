package com.app.ordenaly.controller;

import com.app.ordenaly.model.Order;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.model.Staff;
import com.app.ordenaly.repository.OrderRepository;
import com.app.ordenaly.service.OrderService;
import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalTime;

@WebMvcTest
class OrderControllerTest {
  @Autowired
  private MockMvc mockMvc;
  @MockBean
  private OrderService orderService;
  @MockBean
  private OrderRepository orderRepo;
  @Mock
  private Ticket ticket;
  @Mock
  private Staff user;


  @Test
  void testCreateOrder() {

    Ticket ticket1 = new Ticket();
    ticket1.setId(23);
    ticket1.setTime(LocalTime.now());

    Staff waiter = new Staff();
    waiter.setId(41);
    waiter.setName("Raul");

    Order order = new Order(ticket1, waiter, OrderStatus.PENDIENTE, PaymentStatus.PENDIENTE);

    Mockito
            .when(orderRepo.save(order)).thenReturn(order);

    orderRepo.save(order);

  }


}