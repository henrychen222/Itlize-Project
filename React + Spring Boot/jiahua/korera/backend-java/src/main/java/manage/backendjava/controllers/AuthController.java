package manage.backendjava.controllers;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;
import manage.backendjava.entities.UserEntity;
import manage.backendjava.repositories.UserRepository;
import manage.backendjava.security.JwtTokenProvider;
import manage.backendjava.security.PasswordEncryption;
import manage.backendjava.security.Role;

@RestController
@RequestMapping("/auth")
public class AuthController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @Autowired
  PasswordEncryption passwordEncryption;

  @PostMapping("/register")
  AuthResponse register(@RequestBody UserEntity userEntity)
      throws NoSuchAlgorithmException, InvalidKeySpecException {

    AuthResponse authResponse = new AuthResponse();
    String username = userEntity.getUsername();

    if (userRepository.existsByUsername(username)) {
      throw new Error("User '" + username + "' already exists!");
    }

    String salt = passwordEncryption.generateSalt();
    String password = passwordEncryption.getEncryptedPassword(userEntity.getPassword(), salt);

    userEntity.setSalt(salt);
    userEntity.setPassword(password);
    userEntity.setJoined(new Date());
    userEntity.setRoles(Arrays.asList(Role.ROLE_CLIENT));
    userEntity = userRepository.save(userEntity);
    authResponse.setUserEntity(userEntity);

    String token = jwtTokenProvider.createToken(userEntity.getUsername(), userEntity.getRoles());
    authResponse.setToken(token);

    return authResponse;
  }

  @PostMapping("/login")
  AuthResponse login(@RequestBody UserEntity userEntity)
      throws NoSuchAlgorithmException, InvalidKeySpecException, Error {

    AuthResponse authResponse = new AuthResponse();
    String username = userEntity.getUsername();

    if (!userRepository.existsByUsername(username)) {
      throw new Error("User '" + username + "' doesn't exist!");
    }

    UserEntity foundUserEntity = userRepository.findByUsername(username).get(0);
    if (!passwordEncryption.authenticate(userEntity.getPassword(), foundUserEntity.getPassword(),
        foundUserEntity.getSalt())) {
      throw new Error("Invalid password");
    }

    authResponse.setUserEntity(foundUserEntity);

    String token = jwtTokenProvider.createToken(username, foundUserEntity.getRoles());
    authResponse.setToken(token);

    return authResponse;
  }

  @GetMapping("/init")
  UserEntity init(Authentication authentication) {
    if (authentication == null) {
      throw new Error("Invalid token");
    }
    return (UserEntity) authentication.getPrincipal();
  }
}


@Data
class AuthResponse {
  private UserEntity userEntity;
  private String token;
}
