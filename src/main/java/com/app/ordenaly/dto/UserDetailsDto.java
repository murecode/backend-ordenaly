package com.app.ordenaly.dto;

import com.app.ordenaly.utils.Roles;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDetailsDto {
  private String user_id;
  private String name;
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

  public Roles getRol() {
    return rol;
  }

  public void setRol(Roles rol) {
    this.rol = rol;
  }
}
