package com.app.ordenaly.repository;

import com.app.ordenaly.security.model.User;
import com.app.ordenaly.security.utils.Roles;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 1
@Rollback(value = false)
class UserRepositoryTest {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private EntityManager entityManager;

  @Test
  void testCreateUser() {

    User user = new User();
    user.setUsername("mure2");
    user.setEmail("mure@gmail.com");
    user.setPassword("mure1234");
    user.setRole(Roles.ADMIN);

    userRepository.save(user);

    assertTrue(user.getUsername() != "mure");
    assertTrue(user.getPassword() != "mure123");

  }

  @Test
  void testUpdateUser() {
    User user = entityManager.find(User.class, 0);
    user.setUsername("");
    userRepository.save(user);

    assertTrue(user.getId() == 0);
  }

  @Test
  void testDeleteUser() {
    User user = entityManager.find(User.class, 0);
    userRepository.deleteById( user.getId() );

    assertTrue(user != null );
  }

}

//Docs

// 1. Esta anotacion configura cómo se gestionará la DB durante las pruebas...
// en este caso se indica con "NONE" que la configuración de la DB utilizada...
// en las pruebas sea la misma que que de la DB la app en entorno de producción.