package com.itlize.marketplace.controllers;

import com.itlize.marketplace.entities.SalesRepresentative;
import com.itlize.marketplace.repositories.SalesRepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/salesRepresentative")
public class SalesRepresentativeController extends GenericRestController<SalesRepresentative> {

  @Autowired
  SalesRepresentativeRepository repository;

  @GetMapping("/add")
  SalesRepresentative add() {
    SalesRepresentative salesRepresentative = new SalesRepresentative();
    salesRepresentative.setEmail("email@sales.com");
    salesRepresentative.setName("saler");
    salesRepresentative.setPhone(987654321);
    salesRepresentative.setWeb("sale.com");
    return repository.save(salesRepresentative);
  }

}
