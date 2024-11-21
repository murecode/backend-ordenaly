package com.app.ordenaly.security.config;

import com.app.ordenaly.security.filter.JwtAuthenticationFilter;
import com.app.ordenaly.model.enums.Permissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {
  @Autowired
  private AuthenticationProvider authenticationProvider; //0.
  @Autowired
  private JwtAuthenticationFilter authenticationFilter;

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
    http
            .cors(cors -> cors.configure(http)) //4.
            .csrf(csrfConfig -> csrfConfig.disable()) //1.
            .sessionManagement(sessionMangConfig -> sessionMangConfig
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //2.
            ) //3.
            .authenticationProvider(authenticationProvider)
            .addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .authorizeHttpRequests((authorize) -> {

              authorize.requestMatchers(HttpMethod.POST, "/auth/**").permitAll();
              authorize.requestMatchers("/error").permitAll();

              authorize.requestMatchers(HttpMethod.GET,    "/orders").permitAll();
              authorize.requestMatchers(HttpMethod.GET,    "/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.GET,    "/orders/status/{status}").permitAll();
              authorize.requestMatchers(HttpMethod.GET,    "/orders/order_status/{status}").permitAll();
              authorize.requestMatchers(HttpMethod.POST,   "/orders").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/orders/{id}").authenticated();

              authorize.requestMatchers(HttpMethod.GET,    "/items/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.POST,   "/items/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.PATCH,  "/items/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/items/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/products").permitAll();
              authorize.requestMatchers(HttpMethod.GET, "/products/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.POST, "/products").permitAll();
              authorize.requestMatchers(HttpMethod.PATCH, "/products/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/products/{id}").hasAuthority(Permissions.DELETE_PRODUCT.name());

              authorize.requestMatchers(HttpMethod.GET, "/product_category").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/tickets").permitAll();
              authorize.requestMatchers(HttpMethod.GET, "/tickets/status/{status}").permitAll();
              authorize.requestMatchers(HttpMethod.POST, "/tickets").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/users").permitAll();

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

/*3. sessionManagement, Se encarga de configurar el manejo de sesiones en la aplicación. La
  aplicación no mantendrá el estado de la sesión en el servidor y cada solicitud se manejará
  de manera independiente sin depender del estado de la sesión. Esto es útil en escenarios
  donde se prefiere la arquitectura sin estado, comúnmente asociada con aplicaciones RESTful
  y servicios web.*/

/*4. Asegura que las configuraciones de CORS definidas globalmente se apliquen. Esto es
  importante para manejar solicitudes CORS correctamente.*/
