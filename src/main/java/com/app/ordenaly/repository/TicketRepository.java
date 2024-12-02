package com.app.ordenaly.repository;

import com.app.ordenaly.model.entity.Ticket;
import com.app.ordenaly.model.enums.TicketStatus;
import com.app.ordenaly.presentation.response.TicketStatisticsData;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Integer> {

  @Modifying
  @Transactional
  @Query("UPDATE Ticket t SET t.status = :status WHERE t.id = :id")
  void updateTicketStatus(
          @Param("id") Integer id,
          @Param("status") TicketStatus ticketStatus
  );

  @Query("SELECT t FROM Ticket t WHERE t.status = :status")
  Page<Ticket> findByStatus(
          @Param("status") TicketStatus status,
          Pageable pageable
  );

  @Query("SELECT t.status, COUNT(t) AS quantity FROM Ticket t GROUP BY t.status")
  List<TicketStatisticsData> findTicketStatistics();

}

// DOCS

// La anotación @Modifying se utiliza en combinación con la anotación @Query para indicar que
// una consulta (query) no es solo de lectura, sino que modifica los datos en la base de datos
// Y @Transactional garantiza su consistencia e integridad. Esto es útil para
// operaciones como actualizaciones o eliminaciones.
