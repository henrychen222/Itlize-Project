package com.itlize.marketplace.controllers;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.itlize.marketplace.entities.Manufacturer;
import com.itlize.marketplace.entities.Product;
import com.itlize.marketplace.entities.SalesRepresentative;
import com.itlize.marketplace.repositories.ManufacturerRepository;
import com.itlize.marketplace.repositories.ProductRepository;
import com.itlize.marketplace.repositories.SalesRepresentativeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController extends GenericRestController<Product> {

  @Autowired
  ProductRepository repository;

  @Autowired
  ManufacturerRepository manufacturerRepository;

  @Autowired
  SalesRepresentativeRepository salesRepresentativeRepository;

  @GetMapping("/pair")
  List<?> getPair() {
    return repository.getGroupByCategories();
  }

  @GetMapping("/distinct/category")
  List<String> getDistinctCategories() {
    return repository.getDistinctCategories();
  }

  @GetMapping("/category/{category}")
  List<Product> categories(@PathVariable String category) {
    return repository.findByCategory(category);
  }

  @PostMapping("/build")
  Product build(@RequestBody Product product) {
    Manufacturer manufacturer = product.getManufacturer();
    if (manufacturer != null) {
      manufacturer = manufacturerRepository.save(manufacturer);
      product.setManufacturer(manufacturer);
    }

    SalesRepresentative salesRepresentative = product.getSalesRepresentative();
    if (salesRepresentative != null) {
      salesRepresentative = salesRepresentativeRepository.save(salesRepresentative);
      product.setSalesRepresentative(salesRepresentative);
    }

    return repository.save(product);
  }

  @PostMapping("/batch/build")
  List<Product> batchBuild(@RequestBody List<Product> products) {
    for (Product product : products) {
      Manufacturer manufacturer = product.getManufacturer();
      if (manufacturer != null) {
        manufacturer = manufacturerRepository.save(manufacturer);
        product.setManufacturer(manufacturer);
      }

      SalesRepresentative salesRepresentative = product.getSalesRepresentative();
      if (salesRepresentative != null) {
        salesRepresentative = salesRepresentativeRepository.save(salesRepresentative);
        product.setSalesRepresentative(salesRepresentative);
      }
    }

    return repository.saveAll(products);
  }

  @GetMapping("/subCategory/{subCategory}")
  List<Product> subCategory(@PathVariable String subCategory) {
    return repository.findBySubCategory(subCategory);
  }

  @GetMapping("/test/{param}/{value}")
  Product testAddCategories(@PathVariable String param, @PathVariable String value)
      throws NoSuchMethodException, SecurityException, IllegalAccessException,
      IllegalArgumentException, InvocationTargetException {
    Product product = new Product();
    Class<?> cls = Product.class;
    param = "set" + param.substring(0, 1).toUpperCase() + param.substring(1);
    Method method;
    try {
      method = cls.getDeclaredMethod(param, new Class[] {String.class});
    } catch (Exception e) {
      try {
        method = cls.getDeclaredMethod(param, new Class[] {Integer.class});
      } catch (Exception e1) {
        method = cls.getDeclaredMethod(param, new Class[] {Double.class});
      }
    }
    method.invoke(product, value);
    return repository.save(product);
  }

  @GetMapping("/add")
  Product add() {
    Manufacturer manufacturer = new Manufacturer();
    manufacturer.setDepartment("userLogin");
    manufacturer.setEmail("email@random.com");
    manufacturer.setName("cool Name");
    manufacturer.setPhone(123456789);
    manufacturer.setWeb("http://www.random.org");
    manufacturerRepository.save(manufacturer);

    SalesRepresentative salesRepresentative = new SalesRepresentative();
    salesRepresentative.setEmail("user@login.net");
    salesRepresentative.setName("saler");
    salesRepresentative.setPhone(987654321);
    salesRepresentative.setWeb("sale.com");
    salesRepresentativeRepository.save(salesRepresentative);

    Product product = new Product();
    product.setAccessories("accessories");
    product.setApplication("application");
    product.setCategory("category");

    Map<String, String> data = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;
      {
        put("airflow", "5467");
        put("power-min", "1.95");
        put("power-max", "21.14");
      }
    };
    product.setData(data);

    Map<String, Integer> dataInt = new HashMap<String, Integer>() {
      private static final long serialVersionUID = 1855301064415267547L;

      {
        put("number of fan speeds", 7);
        put("sound at max speed", 35);
      }
    };
    product.setDataInt(dataInt);

    Map<String, Double> dataDouble = new HashMap<String, Double>() {
      private static final long serialVersionUID = 1L;
      {
        put("height-min", 12.3);
        put("height-max", 57.0);
      }
    };
    product.setDataDouble(dataDouble);

    product.setModel("model");
    product.setModelYear(2134);
    product.setMountingLocation("mountingLocation");
    product.setPicturePath(
        "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQhvQ9RjleA0SNPzlpUxcBsYb4CzvllIsi2QEKq8FOHizRdrfuL");
    product.setSeries("series");
    product.setSubCategory("subCategory");
    product.setUseType("useType");
    product.setManufacturer(manufacturer);
    product.setSalesRepresentative(salesRepresentative);
    product.setVerified(new Date());
    product.setDetails(
        "Airfoils – Moso bamboo – 60” diameter Airfoil Finishes – Caramel Bamboo or Cocoa Bamboo Hardware Finishes – Satin Nickel, Oil-Rubbed Bronze, Black or White");

    return repository.save(product);
  }
}
