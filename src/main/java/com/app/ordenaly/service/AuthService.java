package com.app.ordenaly.service;


import com.app.ordenaly.presentation.advice.exception.auth_exception.InvalidCredentialsException;
import com.app.ordenaly.presentation.advice.exception.auth_exception.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import com.app.ordenaly.presentation.request.AuthRequest;
import com.app.ordenaly.presentation.response.AuthResponse;
import com.app.ordenaly.presentation.request.RegisterRequest;
import com.app.ordenaly.model.entity.User;
import com.app.ordenaly.repository.UserRepository;
import com.app.ordenaly.model.enums.Roles;
import com.app.ordenaly.presentation.advice.exception.auth_exception.UserAlreadyExistException;


@Service
public class AuthService {
  @Autowired
  private AuthenticationManager authManager;
  @Autowired
  private PasswordEncoder passwordEncoder;
  @Autowired
  private UserRepository userRepo;
  @Autowired
  private JwtService jwtService;

  @Transactional
  public void register(RegisterRequest registerRequest) {

    String username = registerRequest.getUsername();
    String email = registerRequest.getEmail();

    //Validar: si existe el usuario y contraseña en la base de datos
    Optional<User> userOptional = userRepo.findByUsername(username);
    Optional<User> emailOptional = userRepo.findByEmail(email);

    if (userOptional.isPresent()) {
      throw new UserAlreadyExistException("El Username ya está registrado, intenta otro");
    }

    if (emailOptional.isPresent()) {
      throw new UserAlreadyExistException("El Email ya está registrado, intenta otro");
    }

    User user = new User();
    user.setUsername(registerRequest.getUsername());
    user.setEmail(registerRequest.getEmail());
    user.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
    user.setRole(Roles.USER);
    user.setName(registerRequest.getFullname());
    user.setPhone(registerRequest.getPhone());
    userRepo.save( user );
  }

  public AuthResponse login(AuthRequest authRequest) {

    String username = authRequest.getUsername();

    Optional<User> userOptional = userRepo.findByUsername(username);

    if (!userOptional.isPresent()) {
      throw new UserNotFoundException("El usuario no está registrado");
    }

    //1.
    UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken (
            authRequest.getUsername(), authRequest.getPassword()
    );
    //2.
    authManager.authenticate(authToken);
    //3.
    User user = userRepo.findByUsername(authRequest.getUsername()).get();
    //4.
    String jwt = jwtService.generateToken(user, generateExtraClaims(user));

    return new AuthResponse(jwt);
  }

  private Map<String, Object> generateExtraClaims(User user) {
    Map<String, Object> extraClaims = new HashMap<>();
    extraClaims.put("id", user.getId());
    extraClaims.put("username", user.getUsername());
    extraClaims.put("fullname", user.getName());
    extraClaims.put("email", user.getEmail());
    extraClaims.put("role", user.getRole());
    extraClaims.put("permissions", user.getAuthorities());
    return extraClaims;
  }

}

// Paso 1 y 2 Autenticación del Usuario:
/*1. Representar el token de autenticación basado en el nombre de usuario y la contraseña.
  este se pasa al AuthenticationManager para que intente autenticar al usuario.*/

/*2. AuthenticationManager, Realiza la autenticación utilizando la información
  proporcionada en "authToken". Si es exitoso el token se almacena en el contexto
  de seguridad, para que esté disponible en cualquier parte de la aplicación durante
  la sesión del usuario. */

//3. Recuperación del usuario, Busca el username en la base de datos

//4. Generacion del token, LLama al servicio encargado de generar el JWT crear una respuesta de autenticación "AuthResponse"

