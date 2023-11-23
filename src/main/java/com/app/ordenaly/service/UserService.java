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

  public void createUser(User user, Roles rol) {

    // Verificar si el usuario que realiza la acción tiene el rol de "Administrador"
    // Verificar que el nuevo usuario no exista
    // ...

    // Asignar informacion al nuevo usuario
    // usuario.setUsername(username);
    // usuario.setRoles(roles);

    // Lógica para crear el nuevo usuario
    // usuarioRepository.save(usuario);

  }

  public List<UserDto> findAllUsers() {
    List<User> users = userRepository.findAll();
    return users.stream()
            .map(userMapper::UserToUserDto)
            .collect(Collectors.toList());
  }

  public void deleteUser(int id) {
    User user = userRepository.findById(id).get();
    userRepository.deleteById(user.getId());
  }

}
