package com.app.ordenaly.models;

import jakarta.persistence.*;

@Entity
@Table(name = "STAFF")
public class Staff {

  @Transient
  private String type = "staff";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  private Integer id;

  @Column(name = "FIRST_NAME", length = 45)
  private String name;

  @Column(name = "LASTNAME", length = 45)
  private String lastname;

  @Column(name = "PHONE", length = 15)
  private String phone;

  @Column(name = "ROLE")
  @Enumerated(EnumType.STRING)
  private StaffRole role;


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

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public StaffRole getRole() {
    return role;
  }

  public void setRole(StaffRole role) {
    this.role = role;
  }

}
