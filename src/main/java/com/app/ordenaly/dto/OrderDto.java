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
  private int order;
  private int turno;
  private String mesero;
  private String estado;
  private List<Item> pedido;

  public OrderDto() {};

  public OrderDto(int order, int turno, String mesero, String estado, List<Item> pedido) {
    this.order = order;
    this.turno = turno;
    this.mesero = mesero;
    this.estado = estado;
    this.pedido = pedido;
  }

  public int getOrder() {
    return order;
  }

  public void setOrder(int order) {
    this.order = order;
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

  public List<Item> getPedido() {
    return pedido;
  }

  public void setPedido(List<Item> pedido) {
    this.pedido = pedido;
  }
}
