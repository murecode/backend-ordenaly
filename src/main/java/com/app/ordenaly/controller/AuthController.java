package com.app.ordenaly.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.ordenaly.dto.AuthResponse;
import com.app.ordenaly.dto.AuthRequest;

@RestController
@RequestMapping("/auth")
public class AuthController {
//  @Autowired
//  AuthRequest authRequest;


  @PostMapping(value = "authenticate")
  public String authenticate() {
    return "Autenticado inicia seccion";
  }
  @GetMapping(value = "public-access")
  public String publicAccess() {
    return "Acceso publico";
  }


}
