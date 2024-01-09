package com.app.ordenaly.service;

import com.app.ordenaly.dto.AuthRequest;
import com.app.ordenaly.dto.AuthResponse;
import com.app.ordenaly.dto.RegisterRequest;
import com.app.ordenaly.model.User;
import com.app.ordenaly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;


@Service
public class AuthService {
  @Autowired
  AuthenticationManager authManager;
  @Autowired
  PasswordEncoder passwordEncoder;
  @Autowired
  UserRepository userRepository;
  @Autowired
  JwtService jwtService;

  @Transactional
  public void signup(RegisterRequest registerRequest) {
    User user = new User();
    user.setUsername(registerRequest.getUsername());
    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    userRepository.save( user );

//    String token = generateVerificationToken( user );
  }

//  private void generateVerificationToken(User user) {
//    String token = UUID.randomUUID().toString();
//    VerificationToken verificationToken = new VerificationToken();
//    verificationToken.setToken( token );
//  }


  public AuthResponse login(AuthRequest authRequest) {
    //1
    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken (
            authRequest.getUsername(), authRequest.getPassword()
    );
    //2
    authManager.authenticate( authToken );

    //3
    User user = userRepository.findByUsername(authRequest.getUsername()).get();

    //4
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

//1. Crea un objeto que contiene la info para la utenticación con mtds que retornan username y password
//2. Toma el username y contraseña y lo delega al provedor de autenticacion
//3. Busca el username en la base de datos
//4. Gebera el JWT con sus 3 partes

