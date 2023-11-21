package com.app.ordenaly.config.security;

import com.app.ordenaly.utils.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
            .csrf(csrfConfig -> csrfConfig.disable()) //1.
            .sessionManagement( sessionMangConfig -> sessionMangConfig.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authenticationProvider(authenticationProvider)
            .authorizeHttpRequests((authorize) -> {

              authorize.requestMatchers(HttpMethod.POST, "/auth/authenticate").permitAll();
              authorize.requestMatchers(HttpMethod.GET, "/auth/public-access").permitAll();
              authorize.requestMatchers("/error").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/api/v1/orders/list").permitAll();
              authorize.requestMatchers(HttpMethod.GET, "/api/v1/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.PATCH, "/api/v1/orders/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/products/list").hasAuthority(Permissions.RETRIEVE_ALL_PRODUCTS.name());
              authorize.requestMatchers(HttpMethod.GET, "/products").hasAuthority(Permissions.SAVE_A_PRODUCT.name());

              authorize.anyRequest().denyAll();
            });


    return http.build();
  }

}

//1.
