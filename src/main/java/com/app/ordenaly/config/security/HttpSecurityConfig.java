package com.app.ordenaly.config.security;

import com.app.ordenaly.utils.Permissions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import java.security.Permission;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {
  @Autowired
  private AuthenticationProvider authenticationProvider;
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrfConfig -> csrfConfig.disable()) //*
            .sessionManagement( sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .authorizeHttpRequests((authorize) -> {

              authorize.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
              authorize.requestMatchers(HttpMethod.GET, "/auth/public-access").permitAll();
              authorize.requestMatchers("/error").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/orders/list").permitAll();
              authorize.requestMatchers(HttpMethod.GET, "/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.PATCH, "/orders/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/products/list").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/tickets/list").permitAll();
              authorize.requestMatchers(HttpMethod.POST, "/tickets/new").permitAll();
              authorize.requestMatchers(HttpMethod.POST,"/tickets/{ticketId}/{waiterId}/take").permitAll();

              authorize.requestMatchers(HttpMethod.GET,"/users/list").permitAll();
              authorize.requestMatchers(HttpMethod.POST,"/users/new").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/users/{id}").permitAll();

//              authorize.requestMatchers(HttpMethod.DELETE, "/users/{id}").hasAuthority(Permissions.DELETE_USER.name());
//              authorize.requestMatchers(HttpMethod.GET, "/products/list").hasAuthority(Permissions.DELETE_PRODUCT.name());
//              authorize.requestMatchers(HttpMethod.GET, "/products").hasAuthority(Permissions.SAVE_A_PRODUCT.name());

              authorize.anyRequest().denyAll();
            });

    return http.build();
  }

}

//* Deshabilita los origenes cruzados
