package com.joole.service;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joole.dao.ProductDAO;
import com.joole.dao.SubCategoryDAO;
import com.joole.domain.Product;
import com.joole.domain.SubCategory;
import com.joole.xml.Parameter;

@Service
@Transactional
public class ProductServiceImpl extends ExtractSubCategoryAttribute implements ProductService {

	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private SubCategoryDAO subCategoryDAO;

	@Override
	@Transactional
	public List<Product> getProduct(int pid) {
		// TODO Auto-generated method stub
		List<Product> products = productDAO.getProduct(pid);
		return products;
	}

	@Override
	@Transactional
	public List<Product> getAllProducts() {
		// TODO Auto-generated method stub

		List<Product> products = productDAO.getAllProducts();
		return products;
	}

	@Override
	public List<Product> getProductsByComparison(List<Integer> productList) {
		// TODO Auto-generated method stub
		List<Product> products = productDAO.getProductsByComparison(productList);
		return products;
	}

	@Override
	public List<Product> getProductsByAdvancedSearch() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	@Transactional
	public Map<String, List<Object>> getProductsBySubcategory(String subCategoryName) {
		// TODO Auto-generated method stub
		List<Product> products = productDAO.getProductsBySubcategory(subCategoryName);
		
		// Extract sub category's attribute
		SubCategory subCategory = subCategoryDAO.getSubCategotyBySubcategoryName(subCategoryName);
		
		List<Parameter> parameters = this.extractSubAttribute(subCategory);
		
		HashMap<String, List<Object>> result = new HashMap<String, List<Object>>();
		
		List<Object> productlList = new ArrayList<Object>(products);
		List<Object> paramList = new ArrayList<Object>(parameters);
		
		result.put("products", productlList);
		result.put("attribute", paramList);
		
		return result;
		
	}

	@Override
	@Transactional
	public List<Product> filterProducts(Map<String, Object[]> map) {
		// TODO Auto-generated method stub
		
		String subCategoryName = (String) map.get("sub")[0];
		map.remove("sub");
		List<Product> products = productDAO.getProductsBySubcategory(subCategoryName);

		// filter products
		
		List<Product> results = new ArrayList<Product>();

		for (Product product : products) {
			// get current product summary parameters
			
			boolean qualified = true;

			SAXBuilder saxBuilder = new SAXBuilder();

			try {
				Document document = saxBuilder.build(new StringReader(product.getSummary()));

				Element root = document.getRootElement();

				// compare

				for (String param : map.keySet()) {

					int productValue = Integer.valueOf(root.getChild(param).getValue());
					
					System.out.println(root.getChild(param).getName() + ": " + productValue);
					System.out.println(map.get(param)[0] + "--" + map.get(param)[1]);

					if (productValue < (Integer)map.get(param)[0] || productValue > (Integer)map.get(param)[1]) {
						qualified = false;
						break;
					}
					System.out.println("qualified: " + qualified);
				}

				// get filter element

				if (qualified) {
					results.add(product);
				}

			} catch (JDOMException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}

		}


		return results;

	}

}
