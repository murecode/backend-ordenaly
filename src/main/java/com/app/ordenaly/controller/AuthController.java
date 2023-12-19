package com.app.ordenaly.controller;

import com.app.ordenaly.service.AuthService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.ordenaly.dto.AuthResponse;
import com.app.ordenaly.dto.AuthRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  AuthService authService;

  @PostMapping("/login")
  public ResponseEntity<AuthResponse> login(
          @RequestBody @Valid AuthRequest authRequest) {
    AuthResponse jwtDto = authService.login(authRequest);
    return ResponseEntity.ok(jwtDto);
  }

  @GetMapping("public-access")
  public String publicAccess() {
    return "Acceso publico";
  }


}
