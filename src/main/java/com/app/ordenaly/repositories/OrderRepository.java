package com.app.ordenaly.repositories;

import com.app.ordenaly.models.Order;
import com.app.ordenaly.models.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

}
