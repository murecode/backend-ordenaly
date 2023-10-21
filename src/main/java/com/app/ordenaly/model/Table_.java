package com.app.ordenaly.model;

import jakarta.persistence.*;

@Entity
@Table(name = "TABLE_")
public class Table_ {
  @Transient
  private String type = "table";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "TABLE_ID")
  private Integer id;

  @Column(name = "IDENTIFIER", length = 45)
  private String identifier;


  public Table_() {};

  public Table_(Integer id, String identifier) {
    this.id = id;
    this.identifier = identifier;
  }

  public String getType() {
    return type;
  }

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getIdentifier() {
    return identifier;
  }

  public void setIdentifier(String identifier) {
    this.identifier = identifier;
  }

}
