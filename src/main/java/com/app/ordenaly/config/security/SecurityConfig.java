package com.app.ordenaly.config.security;

import com.app.ordenaly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.core.userdetails.UserDetails;
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
  @Bean
  public AuthenticationProvider authProvider() {
    DaoAuthenticationProvider daoAuthProvider = new DaoAuthenticationProvider();
    daoAuthProvider.setUserDetailsService(userDetailsService());
    daoAuthProvider.setPasswordEncoder(passwordEncoder());
    return daoAuthProvider;
  }
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }
  @Bean
  public UserDetailsService userDetailsService() {
    return username -> {
      return userRepository.findByUsername(username)
              .orElseThrow(() -> new RuntimeException("User Not Found"));
    };
  }

}

//1. Esta linea genera el ProviderManager que puede coordinar varios provedores de autentificacion
