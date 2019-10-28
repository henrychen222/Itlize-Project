package com.itlize.marketplace.controllers;

import com.itlize.marketplace.entities.Address;
import com.itlize.marketplace.entities.UserInfo;
import com.itlize.marketplace.entities.UserLogin;
import com.itlize.marketplace.repositories.AddressRepository;
import com.itlize.marketplace.repositories.UserInfoRepository;
import com.itlize.marketplace.repositories.UserLoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/userInfo")
public class UserInfoController extends GenericRestController<UserInfo> {

  @Autowired
  UserInfoRepository repository;

  @Autowired
  UserLoginRepository userLoginRepository;

  @Autowired
  AddressRepository addressRepository;

  @PostMapping("/connect")
  UserInfo connectUserInfo(@RequestBody UserLogin userLogin) {
    return repository.findByUserLogin(userLogin);
  }

  @GetMapping("/add")
  UserInfo add() {
    Address address = new Address();
    address.setAddrLine1("from userInfo addrLine1");
    address.setAddrLine2("addrLine2");
    address.setCity("city");
    address.setCountry("country");
    address.setState("state");
    address.setZip(12345);

    addressRepository.save(address);

    UserLogin userLogin = new UserLogin();
    userLogin.setEmail("user@login.net");
    userLogin.setPassword("password");
    userLogin.setUsername("user login name");

    userLoginRepository.save(userLogin);

    UserInfo userInfo = new UserInfo();
    userInfo.setFirstName("first name user info");
    userInfo.setLastName("lastName");
    userInfo.setPicturePath(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTfynjc_HJLVAJw7-LrBp46ZVjr0cr--pTC21XYWKZJfO4fOnWd");
    userInfo.setAddress(address);
    userInfo.setUserLogin(userLogin);

    return repository.save(userInfo);
  }

}
