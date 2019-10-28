package com.joole.dao;

import java.util.List;

import com.joole.domain.SubCategory;

public interface SubCategoryDAO {
	
	public SubCategory getSubCategoty(int id);
	
	public List<SubCategory> getSubCategoriesByCategoryName(String categoryName);
	
	public SubCategory getSubCategotyBySubcategoryName(String subCategoryName);

}
