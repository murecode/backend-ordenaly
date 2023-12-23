package com.app.ordenaly.dto;

import com.app.ordenaly.utils.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsDto {
  @JsonIgnore
  private String user_id;
  private String name;
  private String user_name;
  private String password;
  private Roles rol;

  public UserDetailsDto() {};

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getUser_name() {
    return user_name;
  }

  public void setUser_name(String user_name) {
    this.user_name = user_name;
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
