package com.app.ordenaly.models;

import com.app.ordenaly.utils.Roles;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "\"USER\"", uniqueConstraints = {@UniqueConstraint(columnNames = "USERNAME")}) //1.
public class User implements UserDetails {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Integer id;
  @NotNull
  @Column(name = "USERNAME", length = 45)
  private String username;
  @NotNull
  @Column(name = "FULLNAME", length = 45)
  private String fullname;
//  @Column(name = "EMAIL", length = 45)
//  private String email;
  @NotNull
  @Column(name = "PASSWORD")
  private String password;
  @NotNull
  @Column(name = "ROLE")
  @Enumerated(EnumType.STRING)
  private Roles role;

  public User() {};

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

  public String getFullname() {
    return fullname;
  }

  public void setFullname(String fullname) {
    this.fullname = fullname;
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

//1. Define una restricción única en la columna "USERNAME" de la tabla...

//2. "GrantedAuthority", Hace referencia a los permisos que seran concedidos al usuario

//3. Se obtiene una secuencia (stream) de los permisos asociados al rol del usuario...
// devuelviendo una lista de enumeraciones (u objetos) que representan permisos.

//4. Cada permiso se mapea a un objeto SimpleGrantedAuthority que...
// representa una autoridad (rol o permiso).

