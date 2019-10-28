package com.joole.dao;

import java.util.List;

import com.joole.domain.Product;

public interface ProductDAO {
	
	// product list view
	public List<Product> getAllProducts();
	
	public List<Product> getProductsBySubcategory(String subCategory);
	
	// basic product page view
	public List<Product> getProduct(int pid);
	
	// product comparison
	public List<Product> getProductsByComparison(List<Integer> productList);
	
	//advanced product search
	public List<Product> getProductsByAdvancedSearch();
	
	
	
	
	
	

}
