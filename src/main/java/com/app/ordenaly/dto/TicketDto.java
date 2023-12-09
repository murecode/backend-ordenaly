package com.app.ordenaly.dto;

public class TicketDto {
  private int ticketId;
  private String hora;
  private int orden;

  public TicketDto(int ticketId, String hora, int orden) {
    this.ticketId = ticketId;
    this.hora = hora;
    this.orden = orden;
  }

  public int getTicketId() {
    return ticketId;
  }

  public void setTicketId(int ticketId) {
    this.ticketId = ticketId;
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
