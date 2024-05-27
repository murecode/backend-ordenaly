package com.app.ordenaly.models;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "Employee")
@Table(name = "employees")
public class Employee {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private int id;
  @Column
  private String name;
  @ElementCollection
  @OneToMany(mappedBy = "waiter")
  private List<Order> orders;

  public Employee() {}

  public Employee(int id, String name) {
    this.id = id;
    this.name = name;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

}
