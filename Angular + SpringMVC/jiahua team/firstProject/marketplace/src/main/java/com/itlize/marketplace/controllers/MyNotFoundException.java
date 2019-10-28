package com.itlize.marketplace.controllers;

class MyNotFoundException extends RuntimeException {

  private static final long serialVersionUID = 4446246307586740592L;

  MyNotFoundException(Long id) {
    super("Could not find one with id " + id);
  }

  MyNotFoundException(String description) {
    super("Failed with " + description);
  }

}
