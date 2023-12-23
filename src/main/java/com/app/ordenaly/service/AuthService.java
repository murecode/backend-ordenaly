package com.app.ordenaly.service;

import com.app.ordenaly.dto.AuthRequest;
import com.app.ordenaly.dto.AuthResponse;
import com.app.ordenaly.model.User;
import com.app.ordenaly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;


@Service
public class AuthService {
  @Autowired
  AuthenticationManager authManager;
  @Autowired
  UserRepository userRepository;
  @Autowired
  JwtService jwtService;

  public AuthResponse login(AuthRequest authRequest) {
    //*
    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken (
            authRequest.getUsername(), authRequest.getPassword()
    );

    // Toma el username y contraseña y lo delega al provedor de autenticacion
    authManager.authenticate( authToken );
    // Busca el username en la base de datos
    User user = userRepository.findByUsername(authRequest.getUsername()).get();

    //**
    String jwt = jwtService.generateToken(user, generateExtraClaims(user));
    return new AuthResponse(jwt);

  }

  private Map<String, Object> generateExtraClaims(User user) {
    Map<String, Object> extraClaims = new HashMap<>();
    extraClaims.put("name", user.getFullname());
    extraClaims.put("role", user.getRole());
    extraClaims.put("permissions", user.getAuthorities());
    return extraClaims;
  }

}

//* Crea un objeto que contiene la info para la utenticación con mtds que retornan username y password
//** Gebera el JWT con sus 3 partes

