package com.app.ordenaly.infra.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
//@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {

//    registry.addMapping("/**");

//    registry.addMapping("/orders/**")
//            .allowedOrigins("http://localhost:4200")
//            .allowedHeaders("*")
//            .allowedMethods("GET", "POST", "PUT")
//            .allowCredentials(true);
//
//    registry.addMapping("/tickets/**")
//            .allowedOrigins("http://localhost:4200")
//            .allowedHeaders("*")
//            .allowedMethods("GET", "POST", "OPTIONS")
//            .allowCredentials(true);
//
//    registry.addMapping("/products/**")
//            .allowedOrigins("http://localhost:4200" )
//            .allowedHeaders("*")
//            .allowedMethods("GET", "POST", "PATCH", "DELETE", "OPTIONS")
//            .allowCredentials(true);
//
//    registry.addMapping("/carts/**")
//            .allowedOrigins("http://localhost:4200")
//            .allowedHeaders("*")
//            .allowedMethods("GET", "POST", "PUT", "DELETE")
//            .allowCredentials(true);

    registry.addMapping("/**")
            .allowedOrigins("http://localhost:4200")
            .allowedHeaders("*")
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .allowCredentials(true);


  }

}
