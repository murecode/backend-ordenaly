package com.app.ordenaly.service;

//import com.app.ordenaly.models.dto.mapper.UserMapper;
import com.app.ordenaly.model.Employee;
import com.app.ordenaly.security.model.User;
import com.app.ordenaly.repository.EmployeeRepository;
import com.app.ordenaly.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepo;
  //  @Autowired
//  private UserMapper userMapper;
  @Autowired
  private EmployeeRepository employeeRepo;

  public List<User> getAllUsers() {
    List<User> users = userRepo.findAll();
    return users;
  }

  public Employee createUserEmployee(User user, Employee employee) {
    user.setEmployee(employee);
    employee.setUser(user);

    userRepo.save(user);
    return employeeRepo.save(employee);
  }

//  public void updateUserInfo(int userId, User userBody) {
//    User user = userRepository.findById(userId).get();
//    user.setFullname(userBody.getFullname());
//    userRepository.save(user);
//  }

  // UPDATE_USER_CREDENTIALS - autorized only ADMIN
  // user.setUsername(userBody.getUsername());
  // user.setPassword(userBody.getPassword());
  // user.setRole(userBody.getRole());

  public void deleteUser(int id) {
    User user = userRepo.findById(id).get();
    userRepo.deleteById(user.getId());
  }

}
