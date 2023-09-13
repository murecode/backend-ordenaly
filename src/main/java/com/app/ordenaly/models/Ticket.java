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
  @Column(name = "ID")
  private Integer id;

  @Column(name = "TIMESTAMP", length = 8)
  private LocalTime timestamp;

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

  public LocalTime getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(LocalTime timestamp) {
    this.timestamp = timestamp;
  }

}
