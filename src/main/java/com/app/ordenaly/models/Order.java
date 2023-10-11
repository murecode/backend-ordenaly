package com.app.ordenaly.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "ORDERS")
public class Order {

  @Transient
  private String type = "order";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ORDER_ID")
  private Integer id;

  @OneToOne
  @JoinColumn(name = "TICKET_ID")
  private Ticket ticket;

  @OneToOne
  @JoinColumn(name = "STAFF_ID")
  private User staff;

  @ElementCollection
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Item> items = new ArrayList<>();

  //  Status... Proximamente

  public Order() {};

  public Order(Ticket ticket, User staff) {
    this.ticket = ticket;
    this.staff = staff;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public User getStaff() {
    return staff;
  }

  public void setStaff(User staff) {
    this.staff = staff;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public void addItem(Item item) {
    items.add(item);
  }

}
