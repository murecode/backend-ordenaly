package com.app.ordenaly.model.response;

import com.app.ordenaly.model.entities.User;

public record UserData(
        int id,
        String name,
        String email,
        String phone
) {

  public UserData(User user) {
    this(
            user.getId(),
            user.getName(),
            user.getEmail(),
            user.getPhone()
    );
  }

}
