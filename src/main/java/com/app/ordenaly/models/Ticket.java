package com.app.ordenaly.models;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "TICKETS")
public class Ticket {

  @Transient
  private String type = "ticket";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TICKET_ID")
  private Integer id;

  @Column(name = "TICKET_TIME", length = 8)
  private LocalTime time;

  public Ticket() {}

  public Integer getId() {
    return id;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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
