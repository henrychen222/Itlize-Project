package com.itlize.marketplace.controllers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import com.itlize.marketplace.entities.Item;
import com.itlize.marketplace.repositories.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/item")
public class ItemController extends GenericRestController<Item> {

  @Autowired
  ItemRepository repository;

  @GetMapping("/pair")
  List<List<String>> getPair() {
    return repository.getGroupByCategories();
  }

  @GetMapping("/category/{category}")
  List<Item> categories(@PathVariable String category) {
    return repository.findByCategory(category);
  }

  @GetMapping("/subCategory/{subCategory}")
  List<Item> subCategory(@PathVariable String subCategory) {
    return repository.findBySubCategory(subCategory);
  }

  @GetMapping("/add")
  Item add() {
    Item item = new Item();
    Set<String> series_information = new HashSet<>(Arrays.asList("abc", "def", "ghi", "jik"));
    item.setSeries_information(series_information);
    return repository.save(item);
  }

}
