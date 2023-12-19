package com.app.ordenaly.repository;

import com.app.ordenaly.model.User;
import com.app.ordenaly.utils.Roles;
import jakarta.persistence.EntityManager;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

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
<<<<<<< HEAD
    user.setUsername("rosu");
    user.setFirstname("Rosa");
    user.setLastname("Suarez");
    user.setEmail("rosu@ordenaly.com");
    user.setPassword("123456");
=======
    user.setUsername("adal");
    user.setFullname("Adalberto");
    user.setPassword("miclave123");
>>>>>>> wip
    user.setRole(Roles.ADMIN);

    userRepository.save(user);
  }

  @Test
  void testUpdateUser() {}

  @Test
  void testDeleteUser() {}

}

//Docs

// 1. Esta anotacion configura cómo se gestionará la DB durante las pruebas...
// en este caso se indica con "NONE" que la configuración de la DB utilizada...
// en las pruebas sea la misma que que de la DB la app en entorno de producción.