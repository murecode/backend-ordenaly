package com.app.ordenaly.model;

import com.app.ordenaly.utils.OrderStatus;
import com.app.ordenaly.utils.PaymentStatus;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"ORDER\"")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;
  @OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = true)
  @JoinColumn(unique = true)
  private Ticket ticket;
  @ManyToOne()
  @JoinColumn(name = "waiter_id")
  private Employee waiter;
  @Column(name = "mesa", unique = true)
  private int table;
  @ElementCollection
  @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Item> itemlist = new ArrayList<>();
  @Column
  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;
  @Column
  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;
  @Column
  private String notes = " ";

  public Order() {}

  public Order(Ticket ticket, Employee waiter, OrderStatus orderStatus, PaymentStatus paymentStatus) {
    this.ticket = ticket;
    this.waiter = waiter;
    this.orderStatus = orderStatus;
    this.paymentStatus = paymentStatus;
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

  public void setId(int id) {
    this.id = id;
  }

  public Employee getWaiter() {
    return waiter;
  }

  public void setWaiter(Employee waiter) {
    this.waiter = waiter;
  }

  public List<Item> getItemlist() {
    return itemlist;
  }

  public void setItemlist(List<Item> itemlist) {
    this.itemlist = itemlist;
  }

  public int getTable() {
    return table;
  }

  public void setTable(int table) {
    this.table = table;
  }

  public List<Item> getItemList() {
    return itemlist;
  }

  public void setItemList(List<Item> itemlist) {
    this.itemlist = itemlist;
  }

  public void addItem(Item item) {
    itemlist.add(item);
  }

  public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

  public String getNotes() {
    return notes;
  }

  public void setNotes(String notes) {
    this.notes = notes;
  }
}


