package com.itlize.marketplace.controllers;

import com.itlize.marketplace.entities.Address;
import com.itlize.marketplace.repositories.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/address")
public class AddressController extends GenericRestController<Address> {

  @Autowired
  AddressRepository repository;

  @GetMapping("/add")
  Address add() {
    Address address = new Address();
    address.setAddrLine1("addrLine1");
    address.setAddrLine2("addrLine2");
    address.setCity("city");
    address.setCountry("country");
    address.setState("state");
    address.setZip(12345);
    return repository.save(address);
  }

}
