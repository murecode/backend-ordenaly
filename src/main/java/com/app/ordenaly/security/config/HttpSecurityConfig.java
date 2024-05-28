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
  private AuthenticationProvider authenticationProvider;
  @Bean
  public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    http
            .csrf(csrfConfig -> csrfConfig.disable()) //1.
            //.cors(Customizer.withDefaults()) //2.
            .sessionManagement( sessionMangConfig -> sessionMangConfig
                    .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                    .invalidSessionUrl("/api/v1/auth/login")
            ) //3.
            .authenticationProvider(authenticationProvider)
            .authorizeHttpRequests((authorize) -> {

              authorize.requestMatchers(HttpMethod.POST,  "/api/v1/auth/login").permitAll();
              authorize.requestMatchers(HttpMethod.POST,  "/api/v1/auth/signup").permitAll();
              authorize.requestMatchers("/error").permitAll();

              authorize.requestMatchers(HttpMethod.GET,    "/api/v1/orders").permitAll();
              authorize.requestMatchers(HttpMethod.GET,    "/api/v1/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.POST,   "/api/v1/orders/{order-id}").permitAll();
              authorize.requestMatchers(HttpMethod.POST,   "/api/v1/orders").permitAll();
              authorize.requestMatchers(HttpMethod.PUT,    "/api/v1/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/orders/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/orders/item/{item-id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/api/v1/items").permitAll();
              authorize.requestMatchers(HttpMethod.PUT, "/api/v1/items/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/api/v1/products").permitAll();
              authorize.requestMatchers(HttpMethod.POST, "/api/v1/products").permitAll();
              authorize.requestMatchers(HttpMethod.PATCH, "/api/v1/products/{id}").permitAll();
              authorize.requestMatchers(HttpMethod.DELETE, "/api/v1/products/{id}").permitAll();

              authorize.requestMatchers(HttpMethod.GET, "/api/v1/tickets").permitAll();
              authorize.requestMatchers(HttpMethod.POST,"/api/v1/tickets").permitAll();

              authorize.requestMatchers(HttpMethod.GET,   "/api/v1/users").permitAll();
              authorize.requestMatchers(HttpMethod.POST,  "/api/v1/users").permitAll();
              authorize.requestMatchers(HttpMethod.PUT,   "/api/v1/users/{id}").hasAuthority("ADMIN");
              authorize.requestMatchers(HttpMethod.DELETE,"/api/v1/users/{id}").hasAuthority("ADMIN");

              authorize.requestMatchers("/v1/authenticate", "/v3/api-docs/**", "swagger-ui/**","/swagger-ui.html").permitAll();

              authorize.anyRequest().denyAll();
            })
            .formLogin().permitAll();

    return http.build();
  }

}

/*1. Deshabilitar CORS*/

/*2. habilita CORS en tu aplicación de Spring Security con una configuración mínima
prmitiendo el acceso desde cualquier origen, método y encabezado, lo que
puede ser apropiado en ciertos casos, como desarrollo local o pruebas.*/

/*3.[Se encarga de configurar el manejo de sesiones en la aplicación. La aplicación no mantendrá...
el estado de la sesión en el servidor y cada solicitud se manejará de manera independiente sin...
depender del estado de la sesión. Esto es útil en escenarios donde se prefiere la...
arquitectura sin estado, comúnmente asociada con aplicaciones RESTful y servicios web.]*/
