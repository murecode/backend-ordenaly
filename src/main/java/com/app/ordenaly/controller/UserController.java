package com.app.ordenaly.controller;

import com.app.ordenaly.dto.UserDetailsDto;
import com.app.ordenaly.dto.UserDto;
import com.app.ordenaly.dto.mapper.UserDetailsMapper;
import com.app.ordenaly.dto.mapper.UserMapper;
import com.app.ordenaly.model.User;
import com.app.ordenaly.service.UserService;
import jakarta.persistence.Entity;
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
  @Autowired
  UserMapper userMapper;
  @Autowired
  UserDetailsMapper userDetailsMapper;

  @GetMapping("")
  public List<UserDto> getAllUsers() {
    List<User> users = userService.findAllUsers();
    List<UserDto> usersDto = userMapper.usersDto( users );
    return usersDto;
  }

//  @PostMapping("")
//  public ResponseEntity<String> createUser(
//          @RequestBody UserDetailsDto userDetailsDto) {
//    User user = userDetailsMapper.UserDetailsDtoToUser( userDetailsDto );
//    userService.createUser( user );
//    return new ResponseEntity<>("Usuario Creado",HttpStatus.CREATED);
//  }

  @PutMapping("/{id}")
  public ResponseEntity<String> updateUser(
          @PathVariable("id") int userId,
          @RequestBody UserDetailsDto userBody) {
    User user = userDetailsMapper.UserDetailsDtoToUser( userBody );
    userService.updateUser(userId, user);
    return new ResponseEntity<>("Usuario actualizado", HttpStatus.ACCEPTED);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
    userService.deleteUser(id);
    return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
  }

}
