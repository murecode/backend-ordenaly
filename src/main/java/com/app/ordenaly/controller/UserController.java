package com.app.ordenaly.controller;

import com.app.ordenaly.dto.UserDto;
import com.app.ordenaly.model.User;
import com.app.ordenaly.service.UserService;
import com.app.ordenaly.utils.Roles;
import jakarta.persistence.Entity;
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
  public List<UserDto> getAllUsers() {
    return userService.findAllUsers();
  }

  @PostMapping("/new")
  public ResponseEntity<String> createUser(@RequestBody User user) {
    userService.createUser(user);
    return new ResponseEntity<>("Usuario creado",HttpStatus.CREATED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void> deleteUser(@PathVariable("id") int id) {
    userService.deleteUser(id);
    return new ResponseEntity<>(HttpStatus.OK);
  }

  //update

}
