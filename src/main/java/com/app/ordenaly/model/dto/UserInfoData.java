package com.app.ordenaly.model.dto;

import com.app.ordenaly.security.model.User;

public record UserInfoData(String name, String phone) {

  public UserInfoData(User user) {
    this(
            user.getName(),
            user.getPhone()
    );
  }

}
