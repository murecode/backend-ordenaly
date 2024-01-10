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

              authorize.requestMatchers(HttpMethod.POST,  "/api/v1/auth/login").permitAll();
              authorize.requestMatchers(HttpMethod.POST,  "/api/v1/auth/signup").permitAll();
              authorize.requestMatchers("/error").permitAll();

              authorize.requestMatchers(HttpMethod.GET,    "/api/v1/orders").permitAll();
              authorize.requestMatchers(HttpMethod.GET,    "/api/v1/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.POST,   "/api/v1/orders/{id}/add-item/**").permitAll();
              authorize.requestMatchers(HttpMethod.POST,   "/api/v1/orders/**").permitAll(); //La orden se toma desde el ticket
              authorize.requestMatchers(HttpMethod.PUT,    "/api/v1/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/orders/item/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/api/v1/items/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.PUT, "/api/v1/items/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/api/v1/products").permitAll();
              authorize.requestMatchers(HttpMethod.GET, "/api/v1/products/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.POST,"/api/v1/products").permitAll();
              authorize.requestMatchers(HttpMethod.PUT, "/api/v1/products/{id}").permitAll();

//              authorize.requestMatchers(HttpMethod.PATCH, "products/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/products/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/api/v1/tickets").permitAll();
              authorize.requestMatchers(HttpMethod.POST,"/api/v1/tickets").permitAll();

              authorize.requestMatchers(HttpMethod.GET,   "/api/v1/users").permitAll();
              authorize.requestMatchers(HttpMethod.POST,  "/api/v1/users").permitAll();
              authorize.requestMatchers(HttpMethod.PUT,   "/api/v1/users/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE,"/api/v1/users/{id}").permitAll();

//              authorize.requestMatchers(HttpMethod.GET, "/mealtables").permitAll();
//              authorize.requestMatchers(HttpMethod.POST, "/mealtables").permitAll();

              authorize.requestMatchers("/v1/authenticate", "/v3/api-docs/**", "swagger-ui/**","/swagger-ui.html").permitAll();

              authorize.requestMatchers(HttpMethod.DELETE,"/api/v1/users/{id}").hasAuthority(Permissions.DELETE_USER.name());
              authorize.requestMatchers(HttpMethod.GET,   "/api/v1/products").hasAuthority(Permissions.DELETE_PRODUCT.name());
              authorize.requestMatchers(HttpMethod.GET,   "/api/v1/orders").hasAuthority(Permissions.READ_ORDERS.name());

              authorize.anyRequest().denyAll();
            });

    return http.build();
  }

}

//* Deshabilita los origenes cruzados
