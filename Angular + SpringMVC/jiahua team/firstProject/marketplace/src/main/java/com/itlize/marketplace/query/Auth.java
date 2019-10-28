package com.itlize.marketplace.query;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;
import java.util.Map;
import com.itlize.marketplace.entities.UserInfo;
import com.itlize.marketplace.entities.UserLogin;
import com.itlize.marketplace.jwt.JwtTokenProvider;
import com.itlize.marketplace.jwt.PasswordEncryption;
import com.itlize.marketplace.repositories.UserInfoRepository;
import com.itlize.marketplace.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import lombok.Data;

@RestController
@RequestMapping("/auth")
public class Auth {

  @Autowired
  UserLoginRepository repository;

  @Autowired
  UserInfoRepository userInfoRepository;

  @Autowired
  PasswordEncryption passwordEncryption;

  @Autowired
  JwtTokenProvider jwtTokenProvider;

  @PostMapping("/register")
  UserLoginResponse register(@RequestBody UserLogin userLogin)
      throws NoSuchAlgorithmException, InvalidKeySpecException {

    String email = userLogin.getEmail();
    String username = userLogin.getUsername();

    if (repository.countByEmail(email) > 0) {
      throw new Error("User with email `" + email + "` already exists!");
    }

    if (repository.countByUsername(username) > 0) {
      throw new Error("User with username `" + username + "` already exists!");
    }

    UserLoginResponse response = new UserLoginResponse();
    String salt = passwordEncryption.generateSalt();
    String password = passwordEncryption.getEncryptedPassword(userLogin.getPassword(), salt);

    userLogin.setSalt(salt);
    userLogin.setPassword(password);
    userLogin = repository.save(userLogin);

    UserInfo userInfo = new UserInfo();
    userInfo.setUserLogin(userLogin);
    userInfoRepository.save(userInfo);

    response.setUserLogin(userLogin);
    Map<String, String> result = jwtTokenProvider.createToken(userLogin.getId(), true);
    response.setToken(result.get("token"));
    response.setExpiration(result.get("expiration"));
    return response;
  }

  @PostMapping("/login")
  UserLoginResponse login(@RequestBody UserLogin userLogin)
      throws NoSuchAlgorithmException, InvalidKeySpecException {

    UserLoginResponse response = new UserLoginResponse();
    String email = userLogin.getEmail();
    String username = userLogin.getUsername();

    String field;
    String value;
    List<UserLogin> foundUserLogins;
    UserLogin foundUserLogin;

    if (email == null && username == null) {
      throw new Error("Username and email cannot be bo null");
    }

    if (email == null) {
      field = "username";
      value = username;
      foundUserLogins = repository.findByUsername(username);
    } else {
      field = "email";
      value = email;
      foundUserLogins = repository.findByEmail(email);
    }

    if (foundUserLogins.size() == 0) {
      throw new Error(String.format("No such user with %s %s.", field, value));
    } else if (foundUserLogins.size() > 1) {
      throw new Error(String.format("Found multiple users with same %s %s.", field, value));
    } else {
      foundUserLogin = foundUserLogins.get(0);
      if (this.passwordEncryption.authenticate(userLogin.getPassword(),
          foundUserLogin.getPassword(), foundUserLogin.getSalt())) {
        response.setUserLogin(foundUserLogin);

        Map<String, String> result = jwtTokenProvider.createToken(foundUserLogin.getId(), true);
        response.setToken(result.get("token"));
        response.setExpiration(result.get("expiration"));
      } else {
        throw new Error("Wrong password.");
      }
    }

    return response;
  }

}


@Data
class UserLoginResponse {
  private UserLogin userLogin;
  private String token;
  private String expiration;
}
