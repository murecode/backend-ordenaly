package com.app.ordenaly.repositories;

import com.app.ordenaly.models.Employee;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class EmployeeRepositoryTest {
  @Autowired
  private EmployeeRepository employeeRepo;
  @Autowired
  private EntityManager entityManager;

  @Test
  void testCreateEmployee() {
    Employee employee = new Employee();
    employee.setName("Ramiro");

    employeeRepo.save(employee);

    assertTrue(employee.getId() > 0);

  }



}