package com.joole.service;

import java.util.List;
import java.util.Map;

import com.joole.domain.Product;

public interface ProductService {
	
	// product list view
		public Map<String, List<Object>> getProductsBySubcategory(String subCategory);
		
		public List<Product> getAllProducts();
		
		// basic product page view
		public List<Product> getProduct(int pid);
		
		// product comparison
		public List<Product> getProductsByComparison(List<Integer> productList);
		
		//advanced product search
		public List<Product> getProductsByAdvancedSearch();
		
		public List<Product> filterProducts(Map<String, Object[]> map);

}
