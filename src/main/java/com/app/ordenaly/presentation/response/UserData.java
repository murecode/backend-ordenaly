package com.app.ordenaly.presentation.response;

import com.app.ordenaly.model.entity.User;

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
