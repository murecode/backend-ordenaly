package com.app.ordenaly.dto;

public class ItemDto {
  private int id;
  private String producto;
  private int cantidad;

  public ItemDto(int id, String producto, int cantidad) {
    this.id = id;
    this.producto = producto;
    this.cantidad = cantidad;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getProducto() {
    return producto;
  }

  public void setProducto(String producto) {
    this.producto = producto;
  }

  public int getCantidad() {
    return cantidad;
  }

  public void setCantidad(int cantidad) {
    this.cantidad = cantidad;
  }
}
