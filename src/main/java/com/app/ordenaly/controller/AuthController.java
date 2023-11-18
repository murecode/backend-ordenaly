package com.app.ordenaly.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.ordenaly.dto.AuthResponse;
import com.app.ordenaly.dto.AuthRequest;

@RestController
@RequestMapping("api/v1/auth")
public class AuthController {
  @PostMapping(value = "/login")
  public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest authRequest) {
    return null;
  }
  @PostMapping(value = "/register")
  public String register() {
    return "Public Register controller";
  }


}
