package com.app.ordenaly.controller;

import com.app.ordenaly.model.dto.UserInfoData;
import com.app.ordenaly.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
  @Autowired
  UserService userService;

  @GetMapping("")
  public List<UserInfoData> getAllUsers() {
    return userService.getAllUsers();
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
    userService.deleteUser(id);
    return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
  }

}
