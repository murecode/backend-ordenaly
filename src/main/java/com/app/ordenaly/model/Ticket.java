package com.app.ordenaly.model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity
@Table(name = "TICKET")
public class Ticket {

  @Transient
  private String type = "ticket";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TICKET_ID")
  private Integer id;

  @Column(name = "TICKET_TIME", length = 6)
  private LocalTime time;

  //Table_

  @OneToOne
  @JoinColumn(name = "ORDER_ASOC")
  private Order order;

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

  public Order getOrder() {
    return order;
  }

  public void setOrder(Order order) {
    this.order = order;
  }

}
