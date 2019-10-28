package com.itlize.marketplace.controllers;

import com.itlize.marketplace.entities.Manufacturer;
import com.itlize.marketplace.repositories.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/manufacturer")
public class ManufacturerController extends GenericRestController<Manufacturer> {

  @Autowired
  ManufacturerRepository repository;

  @GetMapping("/add")
  Manufacturer add() {
    Manufacturer manufacturer = new Manufacturer();
    manufacturer.setDepartment("department");
    manufacturer.setEmail("email@random.com");
    manufacturer.setName("cool Name");
    manufacturer.setPhone(123456789);
    manufacturer.setWeb("http://www.random.org");
    return repository.save(manufacturer);
  }

}
