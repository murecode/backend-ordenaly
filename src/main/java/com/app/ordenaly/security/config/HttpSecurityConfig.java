package com.app.ordenaly.security.config;

//import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
//import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;

//import java.security.Permission;

@Configuration
@EnableWebSecurity
public class HttpSecurityConfig {
  @Autowired
  private AuthenticationProvider authenticationProvider; //0.
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrfConfig -> csrfConfig.disable()) //1.
            .sessionManagement(sessionMangConfig -> sessionMangConfig
                            .sessionCreationPolicy(SessionCreationPolicy.STATELESS) //2.
//                    .invalidSessionUrl("/api/v1/auth/login") //4.
            ) //3.
            .authenticationProvider(authenticationProvider)
            .authorizeHttpRequests((authorize) -> {

              authorize.requestMatchers(HttpMethod.POST, "/api/v1/auth/login").permitAll();
//              authorize.requestMatchers(HttpMethod.POST,  "/api/v1/auth/signup").permitAll();
//              authorize.requestMatchers("/error").permitAll();
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
//              authorize.requestMatchers(HttpMethod.GET, "/api/v1/products").permitAll();
              authorize.requestMatchers(HttpMethod.POST, "/api/v1/products").authenticated();
//              authorize.requestMatchers(HttpMethod.PATCH, "/api/v1/products/{id}").permitAll();
//              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/products/{id}").permitAll();
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
            })
            .formLogin().permitAll();

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

/*4. invalidSessionUrl(), especifica la URL a la que se redirigirá al usuario cuando su
  sesión sea inválida. Esto puede suceder, por ejemplo, si la sesión expira o si el usuario
  intenta acceder a la aplicación después de que su sesión ha sido invalidada. */

/*3.Se encarga de configurar el manejo de sesiones en la aplicación. La aplicación no mantendrá
  el estado de la sesión en el servidor y cada solicitud se manejará de manera independiente sin
  depender del estado de la sesión. Esto es útil en escenarios donde se prefiere la
  arquitectura sin estado, comúnmente asociada con aplicaciones RESTful y servicios web.*/
