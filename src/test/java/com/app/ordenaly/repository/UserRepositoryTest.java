package com.app.ordenaly.repository;

import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE) // 1
@Rollback(value = false)
class UserRepositoryTest {

}

//Docs

// 1. Esta anotacion configura cómo se gestionará la DB durante las pruebas...
// en este caso se indica con "NONE" que la configuración de la DB utilizada...
// en las pruebas sea la misma que que de la DB la app en entorno de producción.