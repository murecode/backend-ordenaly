package com.app.ordenaly.model;

import jakarta.persistence.*;

@Entity
@Table(name = "USER")
public class User {

  @Transient
  private String type = "user";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Integer id;

  @Column(name = "FIRST_NAME", length = 45)
  private String name;

  @Column(name = "LASTNAME", length = 45)
  private String lastname;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "PHONE", length = 15)
  private String phone;

  @Column(name = "ROLE")
  @Enumerated(EnumType.STRING)
  private UserRole role;


  public String getType() {
    return type;
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

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

}
