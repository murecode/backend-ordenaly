package com.app.ordenaly.controller;

//import com.app.ordenaly.models.dto.UserDetailsDto;
//import com.app.ordenaly.models.dto.mapper.UserDetailsMapper;
//import com.app.ordenaly.models.dto.mapper.UserMapper;
import com.app.ordenaly.model.Staff;
import com.app.ordenaly.security.model.User;
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
  /*@Autowired
  UserMapper userMapper;*/

  @GetMapping("")
  public List<User> getAllUsers() {
    return userService.getAllUsers();
  }

  @PostMapping("")
  public void createStaff(User user, Staff staff) {
    userService.createStaff(user, staff);
  }

  // Solo el ADMIN tiene acceso
//  @PutMapping("/{id}")
//  public ResponseEntity<String> updateUser(
//          @PathVariable("id") int userId,
//          @RequestBody UserDto userBody) {
//    User user = userMapper.UserDtoToUser( userBody );
//    userService.updateUserInfo(userId, user);
//    return new ResponseEntity<>("Usuario actualizado", HttpStatus.ACCEPTED);
//  }

  // Solo el ADMIN tiene acceso
  @DeleteMapping("/{id}")
  public ResponseEntity<String> deleteUser(@PathVariable("id") int id) {
    userService.deleteUser(id);
    return new ResponseEntity<>("Usuario eliminado", HttpStatus.OK);
  }

}
