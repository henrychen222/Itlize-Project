package com.joole.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joole.dao.CategoryDAO;
import com.joole.domain.Category;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Override
	@Transactional
	public List<Category> getCategories() {
		// TODO Auto-generated method stub
		return categoryDAO.getCategories();
	}

}
