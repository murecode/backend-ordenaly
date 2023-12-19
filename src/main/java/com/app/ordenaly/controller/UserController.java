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

  @PostMapping("")
  public ResponseEntity<String> createUser(@RequestBody User user) {
    userService.createUser(user);
    return new ResponseEntity<>("Usuario creado",HttpStatus.CREATED);
  }

  @GetMapping("")
  public List<UserDto> getAllUsers() {
    return userService.findAllUsers();
  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateUser(
          @PathVariable("id") int userId,
          @RequestBody User userBody) {
    userService.updateUser(userId, userBody);
    return new ResponseEntity<>("Usuario actualizado", HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
    userService.deleteUser(id);
    return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
  }

}
