package com.app.ordenaly.config.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {

    registry.addMapping("/**");

    registry.addMapping("/api/v1/orders/**")
            .allowedOrigins("http://localhost:4200", "http://127.0.0.1:5501")
            .allowedMethods("GET", "POST", "PUT")
            .allowCredentials(true);

    registry.addMapping("/api/v1/tickets/**")
            .allowedOrigins("http://localhost:4200", "http://127.0.0.1:5501")
            .allowedMethods("GET", "POST")
            .allowCredentials(true);

    registry.addMapping("/api/v1/products/**")
            .allowedOrigins("http://localhost:4200", "http://127.0.0.1:5501")
            .allowedHeaders("*")
//            .exposedHeaders("Access-Control-Allow-Origin")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true);

    registry.addMapping("/api/v1/items/**")
            .allowedOrigins("http://localhost:4200", "http://127.0.0.1:5501") // Permitir solicitudes desde cualquier origen
            .allowedMethods("DELETE") //Permitir los métodos HTTP específicos
            .allowedHeaders("*") // Permitir todos los encabezados
            .allowCredentials(true);

    registry.addMapping("/api/v1/auth/**")
            .allowedOrigins("*")
            .allowedHeaders("*") // Permitir todos los encabezados
            .allowedMethods("*")
            .allowCredentials(true);

  }

}
