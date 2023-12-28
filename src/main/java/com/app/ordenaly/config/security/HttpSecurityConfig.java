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

              authorize.requestMatchers(HttpMethod.GET,  "/auth/public-access").permitAll();
              authorize.requestMatchers(HttpMethod.POST,  "/auth/login").permitAll();
              authorize.requestMatchers("/error").permitAll();

              authorize.requestMatchers(HttpMethod.GET,    "/orders").permitAll();
              authorize.requestMatchers(HttpMethod.GET,    "/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.POST,   "/orders/{id}/add-item/**").permitAll();
              authorize.requestMatchers(HttpMethod.POST,   "/orders/**").permitAll(); //La orden se toma desde el ticket
              authorize.requestMatchers(HttpMethod.PUT,    "/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/orders/item/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/items/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.PUT, "/items/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/products").permitAll();
              authorize.requestMatchers(HttpMethod.GET, "/products/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.POST,"/products").permitAll();
              authorize.requestMatchers(HttpMethod.PUT, "/products/{id}").permitAll();

//              authorize.requestMatchers(HttpMethod.PATCH, "products/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/products/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/tickets").permitAll();
              authorize.requestMatchers(HttpMethod.POST,"/tickets").permitAll();

              authorize.requestMatchers(HttpMethod.GET,   "/users").permitAll();
              authorize.requestMatchers(HttpMethod.POST,  "/users").permitAll();
              authorize.requestMatchers(HttpMethod.PUT,   "/users/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE,"/users/{id}").permitAll();

              authorize.requestMatchers("/v1/authenticate", "/v3/api-docs/**", "swagger-ui/**","/swagger-ui.html").permitAll();

              authorize.requestMatchers(HttpMethod.DELETE,"/users/{id}").hasAuthority(Permissions.DELETE_USER.name());
              authorize.requestMatchers(HttpMethod.GET,   "/products").hasAuthority(Permissions.DELETE_PRODUCT.name());
              authorize.requestMatchers(HttpMethod.GET,   "/orders").hasAuthority(Permissions.READ_ORDERS.name());

              authorize.anyRequest().denyAll();
            });

    return http.build();
  }

}

//* Deshabilita los origenes cruzados
