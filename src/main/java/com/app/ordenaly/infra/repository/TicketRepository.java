package com.app.ordenaly.infra.repository;

import com.app.ordenaly.model.entities.Ticket;
import com.app.ordenaly.model.enums.TicketStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

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

}
