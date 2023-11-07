package com.app.ordenaly.controller;

import com.app.ordenaly.dto.UserDto;
import com.app.ordenaly.model.User;
import com.app.ordenaly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("/list")
  public List<UserDto> getAllUsers() {
    return userService.findAllUsers();
  }

//  @PostMapping
//  public User newUser() {
//
//  }

}
