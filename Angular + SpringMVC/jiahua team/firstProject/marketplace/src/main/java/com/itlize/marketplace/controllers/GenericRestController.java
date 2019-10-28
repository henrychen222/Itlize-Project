package com.itlize.marketplace.controllers;

import java.util.List;
import com.itlize.marketplace.entities.BaseEntity;
import com.itlize.marketplace.repositories.BaseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

public class GenericRestController<T extends BaseEntity> {

  @Autowired
  private BaseRepository<T> repository;

  @GetMapping
  List<T> all() {
    return repository.findAll();
  }

  @PostMapping("/batch")
  List<T> batchCreate(@RequestBody List<T> entities) {
    return repository.saveAll(entities);
  }

  @PostMapping
  T create(@RequestBody T entity) {
    return repository.save(entity);
  }

  @GetMapping("/id/{id}")
  T one(@PathVariable Long id) {
    return repository.findById(id).orElseThrow(() -> new MyNotFoundException(id));
  }

  @PutMapping("/id/{id}")
  T update(@PathVariable Long id, @RequestBody T entity) {
    return repository.save(entity);
  }

  @DeleteMapping("/id/{id}")
  void delete(@PathVariable Long id) {
    repository.deleteById(id);
  }

}
