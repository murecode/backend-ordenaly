package com.app.ordenaly.service;

import com.app.ordenaly.dto.UserDto;
import com.app.ordenaly.dto.mapper.UserMapper;
import com.app.ordenaly.model.User;
import com.app.ordenaly.repository.UserRepository;
import com.app.ordenaly.utils.Roles;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UserMapper userMapper;


  public User createUser(User userBody) {

    // Verificar si el usuario que realiza la acción tiene el rol de "Administrador"
    // Verificar que el nuevo usuario no exista
    // ...
    User user = new User();
    user.setId(user.getId());
    user.setFullname(userBody.getFullname());
    user.setPassword(userBody.getPassword());
    user.setUsername(userBody.getUsername());
    user.setRole(userBody.getRole());

    return userRepository.save( user );
  }

  public List<User> findAllUsers() {
    List<User> users = userRepository.findAll();
    return users;
  }

  public User updateUser(int userId, User userBody) {
    User user = userRepository.findById(userId).get();
    user.setFullname(userBody.getFullname());
    user.setRole(userBody.getRole());
    return userRepository.save(user);
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
