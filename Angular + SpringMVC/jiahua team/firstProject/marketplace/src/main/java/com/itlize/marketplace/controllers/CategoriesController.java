package com.itlize.marketplace.controllers;

import java.util.HashMap;
import java.util.Map;
import com.itlize.marketplace.entities.Categories;
import com.itlize.marketplace.repositories.CategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoriesController extends GenericRestController<Categories> {

  @Autowired
  CategoriesRepository repository;

  @GetMapping("/add")
  Categories add() {
    Categories categories = new Categories();

    Map<String, String> attributes = new HashMap<String, String>() {
      private static final long serialVersionUID = -1144112929899736073L;

      {
        put("attr1", "value1");
        put("attr2", "value2");
        put("attr3", "value3");
        put("attr4", "value4");
        put("attr5", "value5");
      }
    };

    categories.setAttributes(attributes);
    categories.setCategory("Main random");
    categories.setSubCategory("random sub");
    return repository.save(categories);
  }

}
