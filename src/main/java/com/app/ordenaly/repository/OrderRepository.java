package com.app.ordenaly.repository;

import com.app.ordenaly.model.entity.Order;
import com.app.ordenaly.model.enums.PaymentStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
  @Query("SELECT o FROM Order o WHERE o.paymentStatus = :status")
  Page<Order> findByPaymentStatus(
          @Param("status") PaymentStatus status,
          Pageable pageable
  );

  @Query("SELECT o FROM Order o WHERE o.isOrderComplete = :is")
  Page<Order> findByIsComplete(
          @Param("is") Boolean iscomplete,
          Pageable pageable
  );

}
