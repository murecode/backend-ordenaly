package com.app.ordenaly.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "tickets")
public class Ticket {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;
  @Column
  @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "hh:mm a")
  private LocalTime time;

  // TODO opcion quitar de la orden el Estado del turno y ponerlo aqui
  // TODO agregar mesero asignado a este turno
  // TODO agregar propiedad Datos del cliente (crear clase cliente)


  public Ticket() {}

  public int getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public LocalTime getTime() {
    return time;
  }

  public void setTime(LocalTime time) {
    this.time = time;
  }

}
