package com.app.ordenaly.services;

import com.app.ordenaly.dto.mapper.UserMapper;
import com.app.ordenaly.models.User;
import com.app.ordenaly.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper userMapper;

  public List<User> getAllUsers() {
    List<User> users = userRepository.findAll();
    return users;
  }

  public void updateUserInfo(int userId, User userBody) {
    User user = userRepository.findById(userId).get();
    user.setFullname(userBody.getFullname());
    userRepository.save(user);
  }

  // UPDATE_USER_CREDENTIALS - autorized only ADMIN
  // user.setUsername(userBody.getUsername());
  // user.setPassword(userBody.getPassword());
  // user.setRole(userBody.getRole());

  public void deleteUser(int id) {
    User user = userRepository.findById(id).get();
    userRepository.deleteById(user.getId());
  }

}
