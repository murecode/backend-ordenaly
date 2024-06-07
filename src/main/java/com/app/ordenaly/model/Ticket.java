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

  /*@OneToOne(mappedBy = "ticket") //1.
  private Order order;*/

  public Ticket() {}

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
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

  @Override
  public String toString() {
    return "Ticket{" +
            "id=" + id +
            ", time=" + time +
            '}';
  }
}

//DOCS
/*1. Indica que esta entidad no es la propietaria de la relación. El valor de mappedBy
  debe ser el nombre del atributo en la otra entidad que hace referencia a esta
  entidad (ticket en Order).*/
