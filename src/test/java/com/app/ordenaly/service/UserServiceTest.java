package com.app.ordenaly.service;

import com.app.ordenaly.security.model.User;
import com.app.ordenaly.repository.UserRepository;
import com.app.ordenaly.security.utils.Roles;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test") //1.
@ExtendWith(MockitoExtension.class) //2.
class UserServiceTest {
  @Mock
  private UserRepository userRepo;
  @InjectMocks
  private UserService userService;

  @Test
  void testCreateUser() {
    //Datos de prueba
    User user = new User();
    user.setName("Mario Ospina");
    user.setPhone("31485236");
    user.setUsername("mario22");
    user.setEmail("mario@hotmail");
    user.setPassword("mario123");
    user.setRole(Roles.USER);

    /*Staff staff = new Staff();
    staff.setName("Mario Castaño");*/

    userRepo.save(user);


  }


}

//DOCS
/*1. Permite separar las config de pruebas de las de produccion, config diferentes bases de datos,
  servidores web y otras dependencias */
/*2. Permite usar la biblioteca de Mockito para crear mocks de objetos*/