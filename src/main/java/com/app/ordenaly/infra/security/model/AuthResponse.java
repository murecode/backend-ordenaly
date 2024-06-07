package com.app.ordenaly.infra.security.model;

public class AuthResponse {
  private String jwt;

  public AuthResponse(String jwt) {
    this.jwt = jwt;
  }

  public String getJwt() {
    return jwt;
  }

  public void setJwt(String jwt) {
    this.jwt = jwt;
  }
}
