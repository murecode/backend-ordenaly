package com.app.ordenaly.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {
  private String user_id;
  @JsonIgnore
  private String username;
  private String name;
  private String rol;

  public UserDto() {}

  public UserDto(String name) {
    this.name = name;
  }

  public String getUser_id() {
    return user_id;
  }

  public void setUser_id(String user_id) {
    this.user_id = user_id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

}
