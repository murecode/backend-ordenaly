package com.app.ordenaly.dto;

import com.app.ordenaly.model.Item;
import com.app.ordenaly.model.OrderStatus;
import com.app.ordenaly.model.Ticket;
import com.app.ordenaly.model.User;

import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class OrderDto {
  private int id;
  private int turno;
  private String mesero;
  private String estado;
  private String pago;
  private List<ItemDto> pedido;

  public OrderDto() {};

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getTurno() {
    return turno;
  }

  public void setTurno(int turno) {
    this.turno = turno;
  }

  public String getMesero() {
    return mesero;
  }

  public void setMesero(String mesero) {
    this.mesero = mesero;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public String getPago() {
    return pago;
  }

  public void setPago(String pago) {
    this.pago = pago;
  }

  public List<ItemDto> getPedido() {
    return pedido;
  }

  public void setPedido(List<ItemDto> pedido) {
    this.pedido = pedido;
  }

}
