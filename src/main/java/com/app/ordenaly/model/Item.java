package com.app.ordenaly.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
@Table
public class Item {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  @JsonProperty("item_id")
  private int id;
  @OneToOne
  @JoinColumn
  private Product product;
  @Column
  private int quantity = 1;
  @Column
  private double total;

  public Item() {}

  public Item(Product product, int quantity) {
    this.product = product;
    this.quantity = quantity;
    calculateTotal();
  }

  public double calculateTotal() {
    total = product.getPrice() * getQuantity();
    return total;
  }

  // Getter personalizado para serializar solo el nombre del producto
  @JsonProperty("product_name")
  @JsonGetter("product_name")
  public String getProductName() {
    return this.product.getProductName(); // Retorna solo el nombre del producto
  }

  public Integer getId() {
    return id;
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

  public double getTotal() {
    return total;
  }

  public void setTotal(double total) {
    this.total = total;
  }
}

// GenerationType.IDENTITY,

// @ManyToOne, mapea una relación de muchos a uno entre dos entidades. Esta anotación se coloca...
// en la propiedad de la entidad que representa el lado “muchos” de la relación y se utiliza...
// para especificar la entidad relacionada

// @JoinColumn, especificar una columna de la tabla que se utilizará para la relación entre dos entidades...
// se coloca en la prop de la entidad que representa el lado “uno” de la relación y se utiliza para...
// especificar la column de la tabla que contiene las claves externas que se utilizan para unir las dos tablas