package com.app.ordenaly.model;

import com.app.ordenaly.infra.security.model.User;
import com.app.ordenaly.model.utils.OrderStatus;
import com.app.ordenaly.model.utils.PaymentStatus;
import jakarta.persistence.*;

@Entity
@Table(name = "orders")
public class Order {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;
  @OneToOne()
  @JoinColumn(name = "ticketId")
  private Ticket ticket;
  @ManyToOne()
  @JoinColumn(name = "waiterId")
  private User waiter;
  @Column(name = "mesa", unique = true)
  private String table;
  /*@Column
  @Enumerated(EnumType.STRING)
  private OrderStatus orderStatus;*/
  @Column
  private Boolean isAttended;
  @Column
  @Enumerated(EnumType.STRING)
  private PaymentStatus paymentStatus;


  public Order() {}


  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public Ticket getTicket() {
    return ticket;
  }

  public void setTicket(Ticket ticket) {
    this.ticket = ticket;
  }

  public User getWaiter() {
    return waiter;
  }

  public void setWaiter(User waiter) {
    this.waiter = waiter;
  }

  public String getTable() {
    return table;
  }

  public void setTable(String table) {
    this.table = table;
  }

  /*public OrderStatus getOrderStatus() {
    return orderStatus;
  }

  public void setOrderStatus(OrderStatus orderStatus) {
    this.orderStatus = orderStatus;
  }*/

  public Boolean getAttended() {
    return isAttended;
  }

  public void setAttended(Boolean attended) {
    isAttended = attended;
  }

  public PaymentStatus getPaymentStatus() {
    return paymentStatus;
  }

  public void setPaymentStatus(PaymentStatus paymentStatus) {
    this.paymentStatus = paymentStatus;
  }

}


