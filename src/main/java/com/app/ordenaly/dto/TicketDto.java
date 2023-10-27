package com.app.ordenaly.dto;

public class TicketDto {
  private int id;
  private String hora;
  private int orden;

  public TicketDto(int id, String hora, int orden) {
    this.id = id;
    this.hora = hora;
    this.orden = orden;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getHora() {
    return hora;
  }

  public void setHora(String hora) {
    this.hora = hora;
  }

  public int getOrden() {
    return orden;
  }

  public void setOrden(int orden) {
    this.orden = orden;
  }

}
