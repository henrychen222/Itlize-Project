package com.joole.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.joole.domain.Product;
import com.joole.exception.ProductException;
import com.joole.service.ProductService;

@RestController
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listAllProducts(@RequestHeader("Authorization") String encoding) throws Exception{
		System.out.println("in products");
		System.out.println(encoding);
		List<Product> products = productService.getAllProducts();
		if (products.isEmpty()) {
			throw new ProductException("Oops, no such product");
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	// filter products
	@RequestMapping(value = "/filter", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Product>> filterProducts(@RequestBody Map<String, Object[]> filter) throws Exception {

		System.out.println("filter !!");
		List<Product> products = productService.filterProducts(filter);

		if (products.isEmpty()) {
			throw new ProductException("Oops, no such product");
//			return new ResponseEntity<List<Product>>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/{subCategoryname}", method = RequestMethod.GET)
	public ResponseEntity<Map<String, List<Object>>> listProductsBySubcategory(
			@PathVariable("subCategoryname") String subCategoryname) throws Exception {
		Map<String, List<Object>> map = productService.getProductsBySubcategory(subCategoryname);

		if (map.isEmpty()) {
			throw new ProductException("Oops, no such product");
//			return new ResponseEntity<Map<String, List<Object>>>(HttpStatus.NO_CONTENT);
		}

		return new ResponseEntity<Map<String, List<Object>>>(map, HttpStatus.OK);
	}

	@RequestMapping(value = "/products/pid={productId}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listProductDetails(@PathVariable("productId") int pid) throws Exception {
		List<Product> products = productService.getProduct(pid);
		if (products.isEmpty()) {
			throw new ProductException("Oops, no such product");
//			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);//
		}

		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

	@RequestMapping(value = "/comparison/pl={productList}", method = RequestMethod.GET)
	public ResponseEntity<List<Product>> listProductInComparison(
			@PathVariable("productList") List<Integer> productList) throws Exception{
		List<Product> products = productService.getProductsByComparison(productList);
		if (products.isEmpty()) {
			throw new ProductException("Oops, no such product");
//			return new ResponseEntity<List<Product>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
	}

}
