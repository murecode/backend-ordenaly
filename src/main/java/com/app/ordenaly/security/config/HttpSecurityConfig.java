package com.app.ordenaly.security.config;

import com.app.ordenaly.security.utils.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import com.app.ordenaly.config.security.filter.JwtAuthenticationFilter;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.stereotype.Component;

//import java.security.Permission;

@Component
@EnableWebSecurity
public class HttpSecurityConfig {
  @Autowired
  private AuthenticationProvider authenticationProvider; //0.
  @Autowired
  private JwtAuthenticationFilter authenticationFilter;




  @Bean

  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrfConfig -> csrfConfig.disable()) //1.
            .sessionManagement(sessionMangConfig -> sessionMangConfig
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //2.
            ) //3.
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests((authorize) -> {

              authorize.requestMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll();
              authorize.requestMatchers(HttpMethod.POST, "/api/v1/auth/register").permitAll();
              authorize.requestMatchers("/error").permitAll();
//
//              authorize.requestMatchers(HttpMethod.GET,    "/api/v1/orders").permitAll();
//              authorize.requestMatchers(HttpMethod.GET,    "/api/v1/orders/{id}").permitAll();
//              authorize.requestMatchers(HttpMethod.POST,   "/api/v1/orders/{order-id}").permitAll();
//              authorize.requestMatchers(HttpMethod.POST,   "/api/v1/orders").permitAll();
//              authorize.requestMatchers(HttpMethod.PUT,    "/api/v1/orders/{id}").permitAll();
//              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/orders/{id}").permitAll();
//              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/orders/item/{item-id}").permitAll();
//
//              authorize.requestMatchers(HttpMethod.GET,    "/api/v1/carts/{oid}").permitAll();
//              authorize.requestMatchers(HttpMethod.GET,    "/api/v1/carts/order/{oid}").permitAll();
//              authorize.requestMatchers(HttpMethod.POST,   "/api/v1/carts/add/{pid}/{qty}/{oid}").permitAll();
//
              authorize.requestMatchers(HttpMethod.GET, "/api/v1/products").hasAuthority(Permissions.READ_PRODUCTS.name());
              authorize.requestMatchers(HttpMethod.POST, "/api/v1/products").hasAuthority(Permissions.SAVE_PRODUCT.name());
//              authorize.requestMatchers(HttpMethod.PATCH, "/api/v1/products/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/products/{id}").hasAuthority(Permissions.DELETE_PRODUCT.name());
//
//              authorize.requestMatchers(HttpMethod.GET, "/api/v1/tickets").permitAll();
//              authorize.requestMatchers(HttpMethod.POST,"/api/v1/tickets").permitAll();
//
//              authorize.requestMatchers(HttpMethod.GET,   "/api/v1/users").permitAll();
//              authorize.requestMatchers(HttpMethod.POST,  "/api/v1/users").permitAll();
//              authorize.requestMatchers(HttpMethod.PUT,   "/api/v1/users/{id}").hasAuthority("ADMIN");
//              authorize.requestMatchers(HttpMethod.DELETE,"/api/v1/users/{id}").hasAuthority("ADMIN");

              authorize.requestMatchers("/v1/authenticate", "/v3/api-docs/**", "swagger-ui/**", "/swagger-ui.html").permitAll();

              authorize.anyRequest().denyAll();
            });

    return http.build();
  }

}

/*0. AuthenticationProvider, Interfaz para autenticar las credenciales del usuario
  (como nombre de usuario y contraseña) y proporcionar un Authentication object
  que representa al usuario autenticado. una manera flexible y extensible de manejar
  la autenticación.*/

/*1. Deshabilitar CORS*/

/*2. configurar la política de creación de sesiones de la aplicación. Al establecer la
  política de sesión como STATELESS, se indica a Spring Security que no debe crear ni
  utilizar una sesión HTTP para almacenar información de seguridad.*/

/*3.sessionManagement, Se encarga de configurar el manejo de sesiones en la aplicación. La
  aplicación no mantendrá el estado de la sesión en el servidor y cada solicitud se manejará
  de manera independiente sin depender del estado de la sesión. Esto es útil en escenarios
  donde se prefiere la arquitectura sin estado, comúnmente asociada con aplicaciones RESTful
  y servicios web.*/
