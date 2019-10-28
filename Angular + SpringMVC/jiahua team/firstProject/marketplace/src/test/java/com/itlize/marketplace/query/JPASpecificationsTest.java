package com.itlize.marketplace.query;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import com.itlize.marketplace.entities.Product;
import com.itlize.marketplace.repositories.EntitiesJpaConfig;
import com.itlize.marketplace.repositories.ProductRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EntitiesJpaConfig.class})
@Transactional
public class JPASpecificationsTest {

  @Autowired
  private ProductRepository repository;
  private Product product1;
  private Product product2;
  private Product product3;

  @Test
  public void load_repository_successfully() {
    assertNotNull(repository);
  }

  @Before
  public void init() {
    product1 = new Product();
    product1.setCategory("mechanical");
    product1.setModelYear(2000);
    product1.setSubCategory("hvac fans");
    repository.save(product1);

    product2 = new Product();
    product2.setCategory("MECHANICAL");
    product2.setModelYear(2005);
    product2.setSubCategory("HVAC FANS");
    repository.save(product2);

    product3 = new Product();
    product3.setCategory("electrical");
    product3.setModelYear(2010);
    product3.setSubCategory("laptop");
    repository.save(product3);
    repository.flush();

  }

  @Test
  public void exact_match_given_category_when_get_list_then_correct() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("category", ":", "mechanical"));
    List<Product> results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("category", ":", "mech"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void exact_match_given_category_Capitalized_when_get_list_then_correct() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("category", ":", "MECHANICAL"));
    List<Product> results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("category", ":", "MECH"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void exact_match_given_sub_category_when_get_list_then_correct() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("subCategory", ":", "hvac fans"));
    List<Product> results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", ":", "hvac"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void exact_match_given_sub_category_Capitalized_when_get_list_then_correct() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("subCategory", ":", "HVAC FANS"));
    List<Product> results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", ":", "HVAC"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }


  @Test
  public void pattern_match_given_category_when_get_list_then_correct() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("category", "%", "mechanical"));
    List<Product> results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("category", "%", "mech"));
    results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void pattern_match_given_category_Capitalized_when_get_list_then_correct() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("category", "%", "MECHANICAL"));
    List<Product> results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("category", "%", "MECH"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void pattern_match_given_sub_category_when_get_list_then_correct() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("subCategory", "%", "hvac fans"));
    List<Product> results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", "%", "hvac"));
    results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void pattern_match_given_sub_category_Capitalized_when_get_list_then_correct() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("subCategory", "%", "HVAC FANS"));
    List<Product> results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", "%", "HVAC"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void greater_pattern_test() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("modelYear", ">", 2000));
    List<Product> results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertTrue(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("modelYear", ">", 2005));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertTrue(results.contains(product3));
  }

  @Test
  public void greater_equal_pattern_test() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("modelYear", ">=", 2000));
    List<Product> results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertTrue(results.contains(product2));
    assertTrue(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("modelYear", ">=", 2005));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertTrue(results.contains(product3));
  }

  @Test
  public void less_pattern_test() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("modelYear", "<", 2010));
    List<Product> results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("modelYear", "<", 2005));
    results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void less_equal_pattern_test() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("modelYear", "<=", 2010));
    List<Product> results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertTrue(results.contains(product2));
    assertTrue(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("modelYear", "<=", 2005));
    results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void equal_pattern_test() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("modelYear", "=", 2005));
    List<Product> results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("modelYear", "=", 2007));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void case_insensitive_trim_exact_match() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("category", "~", "mechanical"));
    List<Product> results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("category", "~", "mech"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", "~", " laptop"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertTrue(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", "~", "  laptop   "));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertTrue(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", "~", " lap top"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void case_insensitive_trim_pattern_match() {
    ProductSpecification spec =
        new ProductSpecification(new SearchCriteria("category", "*", "meCHAnical"));
    List<Product> results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("category", "*", "niCa"));
    results = repository.findAll(spec);
    assertTrue(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", "*", " LAPTOP"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertTrue(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", "*", "  laPTop   "));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertTrue(results.contains(product3));

    spec = new ProductSpecification(new SearchCriteria("subCategory", "*", " lap  top"));
    results = repository.findAll(spec);
    assertFalse(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

}
