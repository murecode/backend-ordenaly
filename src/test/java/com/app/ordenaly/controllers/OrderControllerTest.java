package com.app.ordenaly.controllers;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.Ticket;
import com.app.ordenaly.models.Employee;
import com.app.ordenaly.repositories.OrderRepository;
import com.app.ordenaly.services.OrderService;
import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

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
  private Employee user;


  @Test
  void testCreateOrder() {

    Ticket t = new Ticket();
    Employee s = new Employee();

    Order order = new Order(t, s, OrderStatus.PENDIENTE, PaymentStatus.PENDIENTE);

    Mockito
            .when(orderRepo.save(order)).thenReturn(order);

    orderRepo.save(order);

  }


}