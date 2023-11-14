package com.app.ordenaly.repository;

import com.app.ordenaly.model.User;
import com.app.ordenaly.model.UserRole;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

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
    user.setFirstname("Camila");
    user.setLastname("Restrepo");
    user.setEmail("care@ordenaly.com");
    user.setPassword("123qwe");
    user.setRole(UserRole.USER);

    userRepository.save(user);
  }

}

//Docs

// 1. Esta anotacion configura cómo se gestionará la DB durante las pruebas...
// en este caso se indica con "NONE" que la configuración de la DB utilizada...
// en las pruebas sea la misma que que de la DB la app en entorno de producción.