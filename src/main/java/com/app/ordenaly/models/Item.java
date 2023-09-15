package com.app.ordenaly.models;

import jakarta.persistence.*;

@Entity
@Table(name = "ITEMS")
public class Item {
  @Transient
  private String type = "orderItem";

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ITEM_ID")
  private Integer id;

  @OneToOne
  @JoinColumn(name = "PRODUCT_ID")
  private Product product;

  @Column(name = "QUANTITY")
  private Integer quantity;

  public Item(Product product, Integer quantity) {
    this.product = product;
    this.quantity = quantity;
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

  public Product getProduct() {
    return product;
  }

  public void setProduct(Product product) {
    this.product = product;
  }

  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }


  public Item addNewItem(Product product, Integer quantity) {
    return new Item(product, quantity);
  }


}

// GenerationType.IDENTITY,

// @ManyToOne, mapea una relación de muchos a uno entre dos entidades. Esta anotación se coloca...
// en la propiedad de la entidad que representa el lado “muchos” de la relación y se utiliza...
// para especificar la entidad relacionada

// @JoinColumn, especificar una columna de la tabla que se utilizará para la relación entre dos entidades...
// se coloca en la prop de la entidad que representa el lado “uno” de la relación y se utiliza para...
// especificar la column de la tabla que contiene las claves externas que se utilizan para unir las dos tablas