package com.app.ordenaly.config.security.filter;

import com.app.ordenaly.security.model.User;
import com.app.ordenaly.repository.UserRepository;
import com.app.ordenaly.security.service.JwtService;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

@Component
public class JwtAuthenticationFilter extends OncePerRequestFilter {

  @Autowired
  private JwtService jwtService;
  @Autowired
  private UserRepository userRepo;

  @Override
  protected void doFilterInternal(HttpServletRequest request,
                                  HttpServletResponse response,
                                  FilterChain filterChain) throws ServletException, IOException {

    //1. Obtener el Header que contiene el jwt
    String authHeader = request.getHeader("Authorization"); // Bearer jwt

    //Validar si el Auth de Header existe
    if(authHeader == null || !authHeader.startsWith("Bearer ")) {
      filterChain.doFilter(request, response);
      return;
    }

    //2. Obtener el jwt desde el Header
    String jwt = authHeader.split(" ")[1];

    //3. Obtener subject/username desde el jwt
    String username = jwtService.extractUsername(jwt);

    //4. Setear un objeto Authentication dentro del SecurityContext
    User user = userRepo.findByUsername(username).get();
    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(
            username, null, user.getAuthorities()
    );
    SecurityContextHolder.getContext().setAuthentication(authToken);

    //5. Ejecutar el resto de filtros
    filterChain.doFilter(request, response);

  }
}

// DOCS
/* OncePerRequestFilter, clase abstracta de Spring se utiliza para crear filtros de servlet
   que deben ejecutarse SOLO UNA VEZ POR CADA SOLICITUD HTTP. Garantiza que el filtro se
   ejecute solo una vez, independientemente de cuántas veces se solicite el recurso en una
   sola solicitud HTTP.*/
