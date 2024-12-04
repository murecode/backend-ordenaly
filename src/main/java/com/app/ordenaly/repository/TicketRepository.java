package com.app.ordenaly.repository;

import com.app.ordenaly.model.entity.Ticket;
import com.app.ordenaly.model.enums.TicketStatus;
import com.app.ordenaly.presentation.response.TicketStatisticsData;
import jakarta.persistence.Tuple;
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
  List<Tuple> findTicketStatistics();

}

// DOCS

/* La anotación @Modifying se utiliza en combinación con la anotación @Query para indicar que
   una consulta (query) no es solo de lectura, sino que modifica los datos en la base de datos
   Y @Transactional garantiza su consistencia e integridad. Esto es útil para
   operaciones como actualizaciones o eliminaciones. */

/* Importante: Cuando realizas una consulta en JPA que involucra la agregación o combinación de
   diferentes tablas (por ejemplo, usando JOIN, GROUP BY, o funciones de agregación como COUNT,
   SUM, etc.), los resultados no se mapean automáticamente a una entidad o clase específica.
   En su lugar, se representan en una estructura como Map, Object[], o Tuple, dependiendo de
   la consulta y del tipo de resultado.

   la clase Tuple se utiliza para representar resultados de consultas que no se ajustan a una entidad específica.
*/
