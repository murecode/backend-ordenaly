package com.app.ordenaly.model;

import com.app.ordenaly.utils.Roles;
import jakarta.persistence.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Entity
@Table(name = "\"USER\"", uniqueConstraints = {@UniqueConstraint(columnNames = "USERNAME")}) //1.
public class User implements UserDetails {
  @Transient
  private String type = "user";
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "USER_ID")
  private Integer id;
  @Column(name = "USERNAME")
  private String username;
  @Column(name = "FULLNAME", length = 45)
  private String fullname;
//  @Column(name = "EMAIL", length = 45)
//  private String email;
  @Column(name = "PASSWORD")
  private String password;
  @Column(name = "ROLE")
  @Enumerated(EnumType.STRING)
  private Roles role;

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

  //*
  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {

    List<GrantedAuthority> authorities = role.getUserPermissionList().stream()
            .map(permissions -> new SimpleGrantedAuthority(permissions.name()))
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

//* Hace referencia a los permisos concedidos al usuario

