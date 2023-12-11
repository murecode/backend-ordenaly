package com.app.ordenaly.dto;

public class ItemDto {
  private int itemId;
  private String producto;
  private int cantidad;

  public ItemDto(int itemId, String producto, int cantidad) {
    this.itemId = itemId;
    this.producto = producto;
    this.cantidad = cantidad;
  }

  public int getItemId() {
    return itemId;
  }

  public void setItemId(int itemId) {
    this.itemId = itemId;
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
