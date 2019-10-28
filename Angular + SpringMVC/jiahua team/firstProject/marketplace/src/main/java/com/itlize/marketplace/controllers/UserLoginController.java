package com.itlize.marketplace.controllers;

import java.util.List;
import com.itlize.marketplace.entities.UserLogin;
import com.itlize.marketplace.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userLogin")
public class UserLoginController extends GenericRestController<UserLogin> {

  @Autowired
  UserLoginRepository repository;

  @GetMapping("/username/{username}")
  List<UserLogin> getByUsername(@PathVariable String username) {
    return repository.findByUsername(username);
  }

  @GetMapping("/email/{email}")
  List<UserLogin> getByEmail(@PathVariable String email) {
    return repository.findByEmail(email);
  }

  @GetMapping("/add")
  UserLogin add() {
    UserLogin userLogin = new UserLogin();
    userLogin.setEmail("login@logout.com");
    userLogin.setPassword("password");
    userLogin.setUsername("name");
    return repository.save(userLogin);
  }

}
