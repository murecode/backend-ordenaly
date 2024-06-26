package com.app.ordenaly.model.dtos;

import com.app.ordenaly.infra.security.model.User;

public record UserData(int id, String name, String phone) {

  public UserData(User user) {
    this(
            user.getId(),
            user.getName(),
            user.getPhone()
    );
  }

}
