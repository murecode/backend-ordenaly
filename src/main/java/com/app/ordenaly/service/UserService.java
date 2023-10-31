package com.app.ordenaly.service;

import com.app.ordenaly.dto.UserDto;
import com.app.ordenaly.dto.mapper.UserMapper;
import com.app.ordenaly.model.User;
import com.app.ordenaly.repository.UserRepository;
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

  public List<UserDto> findAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream()
            .map(userMapper::UserToUserDto)
            .collect(Collectors.toList());
  }

}
