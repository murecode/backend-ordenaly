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
  @JoinColumn(name = "TICKET")
  private Ticket ticket;

  @OneToOne
  @JoinColumn(name = "WAITER")
  private User waiter;

  @ElementCollection
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Item> itemlist = new ArrayList<>();

  @Column(name = "NOTES")
  private String notes;

  @Column(name = "ORDER_STATUS")
  @Enumerated()
  private OrderStatus orderStatus;

  public Order() {};

  public Order(Ticket ticket, User waiter, String notes, OrderStatus status) {
    this.ticket = ticket;
    this.waiter = waiter;
    this.notes = notes;
    this.orderStatus = status;
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
    return waiter;
  }

  public void setUser(User waiter) {
    this.waiter = waiter;
  }

  public List<Item> getItemList() {
    return itemlist;
  }

  public void setItemList(List<Item> itemlist) {
    this.itemlist = itemlist;
  }

  public void addItem(Item item) {
//    if (items.contains(item.getProduct())) {
//      System.out.println("El elemnto ya existe");
//    }
    itemlist.add(item);
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }
}
