package com.app.ordenaly.model.entity;

import com.app.ordenaly.model.enums.Roles;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "users", uniqueConstraints = {
        @UniqueConstraint(columnNames = "username"),
        @UniqueConstraint(columnNames = "email")
}) //1.
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column
  private Integer id;
  @Column
  private String username;
  @Column
  private String email;
  @Column
  private String password;
  @Column
  @Enumerated(EnumType.STRING)
  private Roles role;
  @Column
  private String name;
  @Column
  private String phone;

  public User() {}

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
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

  public Roles getRole() {
    return role;
  }

  public void setRole(Roles role) {
    this.role = role;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  @Override
  public String toString() {
    return "User{" +
            "id=" + id +
            ", username='" + username + '\'' +
            ", email='" + email + '\'' +
            ", password='" + password + '\'' +
            ", role=" + role +
            ", name='" + name + '\'' +
            ", phone='" + phone + '\'' +
            '}';
  }

  //2.
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    List<GrantedAuthority> authorities = role.getUserPermissionList().stream() //3.
            .map(permissions -> new SimpleGrantedAuthority(permissions.name())) //4.
            .collect(Collectors.toList());

    authorities.add(new SimpleGrantedAuthority("ROLE_" + role.name()));

    return authorities;
  }

  @Override
  public boolean isAccountNonExpired() { return true; }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}

//DOCS:

/*1. Define una restricción única se aplica en el nivel de la clase de la entidad y
  especifica que una o más columnas deben tener valores únicos*/

/*2. "GrantedAuthority", Hace referencia a los permisos o rol que seran concedidos al usuario.*/

/*3. Se obtiene una secuencia (stream) de los permisos asociados al rol del usuario
  devuelviendo una lista de enumeraciones (u objetos) que representan permisos.*/

/*4. Cada permiso se mapea a un objeto SimpleGrantedAuthority el cual Representa
  una autoridad o rol que es otorgado a un usuario. */

