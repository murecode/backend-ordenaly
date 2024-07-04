package com.app.ordenaly.service;

//import com.app.ordenaly.models.dto.mapper.UserMapper;
//import com.app.ordenaly.model.Staff;
import com.app.ordenaly.model.response.UserData;
import com.app.ordenaly.model.entities.User;
//import com.app.ordenaly.infra.repository.StaffRepository;
import com.app.ordenaly.infra.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
  @Autowired
  private UserRepository userRepo;

  public List<UserData> getAllUsers() {
    List<UserData> users = userRepo.findAll().stream().map(UserData::new).toList();
    return users;
  }

/*  public Staff createStaff(User user, Staff staff) {
    user.setStaff(staff);
    staff.setUser(user);

    userRepo.save(user);
    return employeeRepo.save(staff);
  }*/

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
