package com.app.ordenaly.service;

import com.app.ordenaly.model.request.AuthRequest;
import com.app.ordenaly.model.response.AuthResponse;
import com.app.ordenaly.model.request.RegisterRequest;
import com.app.ordenaly.model.entities.User;
import com.app.ordenaly.infra.repository.UserRepository;
import com.app.ordenaly.model.enums.Roles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;


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

