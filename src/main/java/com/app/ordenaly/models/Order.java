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
  @JoinColumn(name = "USER_ID")
  private User user;

  @ElementCollection
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Item> items = new ArrayList<>();

  @Column(name = "ORDER_STATUS")
  @Enumerated()
  private OrderStatus orderStatus;

  public Order() {};

  public Order(Ticket ticket, User user) {
    this.ticket = ticket;
    this.user = user;
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

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }

  public List<Item> getItems() {
    return items;
  }

  public void setItems(List<Item> items) {
    this.items = items;
  }

  public void addItem(Item item) {
//    if (items.contains(item.getProduct())) {
//      System.out.println("El elemnto ya existe");
//    }
    items.add(item);
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }
}
