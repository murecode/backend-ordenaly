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

  public User createUser(User user) {
    // Verificar si el usuario que realiza la acción tiene el rol de "Administrador"
    // Verificar que el nuevo usuario no exista
    // ...
    User newUser = new User();
    newUser.setFullname(newUser.getFullname());
    newUser.setPassword(newUser.getPassword());
    newUser.setUsername(newUser.getUsername());
    newUser.setRole(newUser.getRole());

    return userRepository.save(newUser);
  }

  public List<UserDto> findAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream()
            .map(userMapper::UserToUserDto)
            .collect(Collectors.toList());
  }

  public User updateUser(int userId, User userBody) {
    User user = userRepository.findById(userId).get();
    user.setFullname(userBody.getFullname());
    user.setRole(userBody.getRole());
    user.setUsername(userBody.getUsername());
    user.setPassword(userBody.getPassword());
    return userRepository.save(user);
  }

  public void deleteUser(int id) {
    User user = userRepository.findById(id).get();
    userRepository.deleteById(user.getId());
  }

}
