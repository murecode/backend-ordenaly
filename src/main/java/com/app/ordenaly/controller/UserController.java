package com.app.ordenaly.controller;

import com.app.ordenaly.model.response.UserData;
import com.app.ordenaly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("")
  public List<UserData> getAllUsers() {
    return userService.getAllUsers();
  }


}
