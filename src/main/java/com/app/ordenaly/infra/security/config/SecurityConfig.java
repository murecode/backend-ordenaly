package com.app.ordenaly.infra.security.config;

import com.app.ordenaly.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class SecurityConfig {
  @Autowired
  private UserRepository userRepository;

  @Bean //1.
  public AuthenticationManager authManager(AuthenticationConfiguration authConfig) throws Exception {
    return authConfig.getAuthenticationManager();
  }

  @Bean //2.
  public AuthenticationProvider authProvider() {
    DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
    provider.setUserDetailsService(userDetailsService());
    provider.setPasswordEncoder(passwordEncoder());
    return provider;
  }

  @Bean   //3.
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean  //4.
  public UserDetailsService userDetailsService() {
    return username -> {
      return userRepository.findByUsername(username)
              .orElseThrow(() -> new RuntimeException("🔴 Usuario no encontrado"));
    };
  }

}

//1. Esta linea genera el ProviderManager que puede coordinar varios provedores de autentificacion

/*2. autentica usuarios contra una base de datos o cualquier otra fuente de datos, cifra y
  comparar contraseñas, mejorando la seguridad al no almacenar ni transmitir contraseñas en texto plano.*/

/*3. Compara y codifica la contraseña traida desde la base de datos. */

/*4. La interfaz 'UserserDetailsService' cargar información sobre un usuario dado su nombre
     de username en la base de datos retornando un objeto 'UserDetails' que contiene info la
     que representa al usuario. */

