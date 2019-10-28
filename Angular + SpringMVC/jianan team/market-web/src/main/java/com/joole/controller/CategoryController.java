package com.joole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joole.domain.Category;
import com.joole.service.CategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@RequestMapping(value="/categories", method = RequestMethod.GET)
	public ResponseEntity<List<Category>> getCategories() {

		List<Category> categories = categoryService.getCategories();

		if (categories.isEmpty()) {
			return new ResponseEntity<List<Category>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Category>>(categories, HttpStatus.OK);
	}

}
