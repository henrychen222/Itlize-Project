package com.joole.service;

import java.util.List;

import com.joole.domain.SubCategory;

public interface SubCategoryService {
	

	public SubCategory getSubCategoryAttributeById(int sub_id);
	
	public List<SubCategory> getSubCategoriesByCategoryName(String categoryName);
	
	public SubCategory getSubCategoryBySubCategoryName(String subCategoryName);
	

}
