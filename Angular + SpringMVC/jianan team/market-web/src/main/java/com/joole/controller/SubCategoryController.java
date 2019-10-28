package com.joole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joole.domain.SubCategory;
import com.joole.service.SubCategoryService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class SubCategoryController {

	@Autowired
	private SubCategoryService subCategoryService;

	@RequestMapping(value = "/subcategory/{category_name}", method = RequestMethod.GET)
	public ResponseEntity<List<SubCategory>> getSubCategoriesByCategoryName(@PathVariable("category_name") String category_name) {
		List<SubCategory> subCategories = subCategoryService.getSubCategoriesByCategoryName(category_name);
		
		if (subCategories.isEmpty()) {
			return new ResponseEntity<List<SubCategory>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SubCategory>>(subCategories, HttpStatus.OK);

	}

}
