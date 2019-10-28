package com.joole.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joole.dao.SubCategoryDAO;
import com.joole.domain.SubCategory;

@Service
@Transactional
public class SubCategoryServiceImpl implements SubCategoryService {

	@Autowired
	private SubCategoryDAO subCategoryDAO;

	@Override
	@Transactional
	public SubCategory getSubCategoryAttributeById(int sub_id) {
		// TODO Auto-generated method stub
		SubCategory subCategory = subCategoryDAO.getSubCategoty(sub_id);

		return subCategory;
	}

	@Override
	@Transactional
	public List<SubCategory> getSubCategoriesByCategoryName(String categoryName) {
		// TODO Auto-generated method stub
		List<SubCategory> subCategories = subCategoryDAO.getSubCategoriesByCategoryName(categoryName);
		return subCategories;
	}

	@Override
	@Transactional
	public SubCategory getSubCategoryBySubCategoryName(String subCategoryName) {
		SubCategory subCategory = subCategoryDAO.getSubCategotyBySubcategoryName(subCategoryName);
		return subCategory;
	}

}
