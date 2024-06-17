package com.app.ordenaly.infra.security.model;

import com.app.ordenaly.infra.security.utils.Roles;
import jakarta.validation.constraints.NotBlank;

public class RegisterRequest {
  @NotBlank
  private String fullname;
  @NotBlank
  private String phone;
  @NotBlank
  private String email;
  @NotBlank
  private String username;
  @NotBlank
  private String password;

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

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

}
