//package com.app.ordenaly.config.security.filter;
//
//import com.app.ordenaly.models.User;
//import com.app.ordenaly.repositories.UserRepository;
//import com.app.ordenaly.services.JwtService;
//import jakarta.servlet.FilterChain;
//import jakarta.servlet.ServletException;
//import jakarta.servlet.http.HttpServletRequest;
//import jakarta.servlet.http.HttpServletResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Component;
//import org.springframework.web.filter.OncePerRequestFilter;
//
//import java.io.IOException;
//
//@Component
//public class JwtAuthenticationFilter extends OncePerRequestFilter {
//
//  @Autowired
//  private JwtService jwtService;
//  @Autowired
//  private UserRepository userRepository;
//
//  @Override
//  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
//
//    //1. Obtener el Header que contiene el JWT
//    String authHeader = request.getHeader("Authorization"); // Bearer JWT
//
//    //2. Obtener el JWT desde el Header
//    String jwt = authHeader.split(" ")[1];
//
//    //3. Obtener subject/username desde el JWT
//    String username = jwtService.extractUsername(jwt);
//
//    //4.
//    User user = userRepository.findByUsername(username).get();
//    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
//            username, null, user.getAuthorities()
//    );
//
//    SecurityContextHolder.getContext().setAuthentication(authToken);
//
//    filterChain.doFilter(request, response);
//
//  }
//}
//
//// DOCS
///* OncePerRequestFilter, clase abstracta de Spring se utiliza para crear filtros de servlet
//   que deben ejecutarse solo una vez por cada solicitud HTTP. Garantiza que el filtro se
//   ejecute solo una vez, independientemente de cuántas veces se solicite el recurso en una
//   sola solicitud HTTP.*/
