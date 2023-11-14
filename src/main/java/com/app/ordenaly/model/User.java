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

  @Column(name = "FIRSTNAME", length = 45)
  private String firstname;

  @Column(name = "LASTNAME", length = 45)
  private String lastname;

  @Column(name = "EMAIL")
  private String email;

  @Column(name = "PASSWORD")
  private String password;

  @Column(name = "ROLE")
  @Enumerated(EnumType.STRING)
  private UserRole role;

  public User() {};

  public String getType() {
    return type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getFirstname() {
    return firstname;
  }

  public void setFirstname(String firstname) {
    this.firstname = firstname;
  }

  public String getLastname() {
    return lastname;
  }

  public void setLastname(String lastname) {
    this.lastname = lastname;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public UserRole getRole() {
    return role;
  }

  public void setRole(UserRole role) {
    this.role = role;
  }

}
