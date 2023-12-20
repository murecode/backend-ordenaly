package com.app.ordenaly.dto;

public class UserDto {
  private int userId;
  private String name;
  private String rol;

  public UserDto(int userId, String name, String rol) {
    this.userId = userId;
    this.name = name;
    this.rol = rol;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getName() {
    return name;
  }

  public void setNombre(String name) {
    this.name = name;
  }

  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }

}
