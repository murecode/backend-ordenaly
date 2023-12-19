package com.app.ordenaly.dto;

public class UserDto {
  private int userId;
  private String nombre;

  private String rol;

  public UserDto(int userId, String nombre, String rol) {
    this.userId = userId;
    this.nombre = nombre;
    this.rol = rol;
  }

  public int getUserId() {
    return userId;
  }

  public void setUserId(int userId) {
    this.userId = userId;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }


  public String getRol() {
    return rol;
  }

  public void setRol(String rol) {
    this.rol = rol;
  }
}
