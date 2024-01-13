package com.app.ordenaly.controller;

import com.app.ordenaly.dto.SignUpRequest;
import com.app.ordenaly.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.*;

import com.app.ordenaly.dto.AuthResponse;
import com.app.ordenaly.dto.AuthRequest;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

  @Autowired
  AuthService authService;

  @PostMapping("/signup")
  public void signup(@RequestBody SignUpRequest registerRequest){
    authService.signup(registerRequest);
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
