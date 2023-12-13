package com.app.ordenaly.dto;

public class ProductDto {
  private int productoId;
  private String nombre;
  private String descripcion;
  private Double precio;
  private Boolean disponible;

  public ProductDto(int productoId, String nombre, String descripcion, Double precio, Boolean disponible) {
    this.productoId = productoId;
    this.nombre = nombre;
    this.descripcion = descripcion;
    this.precio = precio;
    this.disponible = disponible;
  }

  public int getProductoId() {
    return productoId;
  }

  public void setProductoId(int productoId) {
    this.productoId = productoId;
  }

  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public String getDescripcion() {
    return descripcion;
  }

  public void setDescripcion(String descripcion) {
    this.descripcion = descripcion;
  }

  public Double getPrecio() {
    return precio;
  }

  public void setPrecio(Double precio) {
    this.precio = precio;
  }

  public Boolean getDisponible() {
    return disponible;
  }

  public void setDisponible(Boolean disponible) {
    this.disponible = disponible;
  }
}
