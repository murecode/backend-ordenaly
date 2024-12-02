package com.app.ordenaly.service;

import com.app.ordenaly.presentation.response.TicketStatisticsData;
import com.app.ordenaly.repository.TicketRepository;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class TicketServiceTest {

  @MockBean
  private TicketRepository ticketRepo;

  @Autowired
  private TicketService ticketService;

  @Test
  void testGetTicketStatistics() {

    // Crear datos simulados para el repositorio
    List<TicketStatisticsData> mockStats = List.of(
            new TicketStatisticsData("WAITING", 10L),
            new TicketStatisticsData("ATTENDED", 5L),
            new TicketStatisticsData("CANCELED", 3L)
    );

    // Simular el comportamiento del repositorio para que devuelva los datos mockeados
    Mockito.when(ticketRepo.findTicketStatistics()).thenReturn(mockStats);

    // Ejecutar el metodo que estamos probando
    Map<String, Long> result = ticketService.getTicketStatistics();

    // Verificar que el resultado es el esperado
    assertEquals(10L, result.get("WAITING"));
    assertEquals(5L, result.get("ATTENDED"));
    assertEquals(3L, result.get("CANCELED"));

  }

}