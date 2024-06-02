package com.app.ordenaly.security.model;

import com.app.ordenaly.security.utils.Roles;

public class RegisterRequest {
  private String email;
  private String username;
  private String password;
  private Roles rol;

  public RegisterRequest() {}

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public Roles getRol() {
    return rol;
  }

  public void setRol(Roles rol) {
    this.rol = rol;
  }
}
