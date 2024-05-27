package com.app.ordenaly.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class UserDto {
  private String id;
  @JsonIgnore
  private String username;
  private String name;
  private String rol;

  public UserDto() {}

  public UserDto(String name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
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
