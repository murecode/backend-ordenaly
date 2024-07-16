package com.app.ordenaly.infra.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {
  @Override
  public void addCorsMappings(CorsRegistry registry) {

//    registry.addMapping("/**");

    registry.addMapping("/orders/**")
            .allowedOrigins("http://localhost:4200", "http://localhost:5173/")
            .allowedMethods("GET", "POST", "PUT")
            .allowCredentials(true);

    registry.addMapping("/tickets/**")
            .allowedOrigins("http://localhost:4200", "http://localhost:5173/")
            .allowedMethods("GET", "POST")
            .allowCredentials(true);
//
    registry.addMapping("/products/**")
            .allowedOrigins("http://localhost:4200" )
            .allowedHeaders("*")
//            .exposedHeaders("Access-Control-Allow-Origin")
            .allowedMethods("GET", "POST", "PUT", "DELETE")
            .allowCredentials(true);

    registry.addMapping("/carts/**")
            .allowedOrigins("http://localhost:4200") // Permitir solicitudes desde cualquier origen
            .allowedMethods("GET", "POST", "PUT", "DELETE") //Permitir los métodos HTTP específicos
            .allowedHeaders("*") // Permitir todos los encabezados
            .allowCredentials(true);

    registry.addMapping("/auth/**")
            .allowedOrigins("http://localhost:4200")
//            .allowedHeaders("*")
            .allowedMethods("POST")
            .allowCredentials(true);

  }

}
