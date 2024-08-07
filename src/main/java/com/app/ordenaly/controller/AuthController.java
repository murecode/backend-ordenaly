package com.app.ordenaly.controller;

import com.app.ordenaly.model.request.RegisterRequest;
import com.app.ordenaly.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import com.app.ordenaly.model.response.AuthResponse;
import com.app.ordenaly.model.request.AuthRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  AuthService authService;

  @PostMapping(value = "/register", consumes = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<String> resgister(@RequestBody @Valid RegisterRequest registerRequest){
    authService.register(registerRequest);
    return new ResponseEntity<>("User created successfully", HttpStatus.OK);
  }

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(
          @RequestBody @Valid AuthRequest authRequest) {
    try {
      AuthResponse jwtDto = authService.login(authRequest);
      return ResponseEntity.ok(jwtDto);
    } catch (BadCredentialsException exception) {
      return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
    }
  }

}
