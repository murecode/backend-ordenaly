package com.app.ordenaly.service;

import com.app.ordenaly.model.User;
import com.app.ordenaly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepository;

  public List<User> findAllUsers() {
    return userRepository.findAll();
  }

}
