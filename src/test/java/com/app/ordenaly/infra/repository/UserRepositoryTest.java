package com.app.ordenaly.infra.repository;

import com.app.ordenaly.model.entities.User;
import com.app.ordenaly.model.enums.Roles;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) //1.
@Rollback(value = false)
class UserRepositoryTest {
  @Autowired
  private UserRepository userRepo;
  @Autowired
  private EntityManager entityManager;

/*  @Test
  void testCreateUser() {

    User user = new User();
    user.setName("Adalber");
    user.setPhone("3148652");
    user.setUsername("mure");
    user.setEmail("mure@gmail.com");
    user.setPassword("mure123");
    user.setRole(Roles.USER);

    userRepo.save(user);

  }*/

/*  @Test
  void testUpdateUser() {
    User user = entityManager.find(User.class, 0);
    user.setUsername("");
    userRepo.save(user);

    assertTrue(user.getId() == 0);
  }*/

  /*@Test
  void testDeleteUser() {
    User user = entityManager.find(User.class, 2);
    userRepo.deleteById( user.getId() );

    assertTrue(user.getUsername() == "mure" );

  }*/

}

//Docs

/*1. Esta anotacion configura cómo se gestionará la DB durante las pruebas
  en este caso se indica con "NONE" que la configuración de la DB utilizada
  en las pruebas sea la misma que que de la DB la app en entorno de producción.*/