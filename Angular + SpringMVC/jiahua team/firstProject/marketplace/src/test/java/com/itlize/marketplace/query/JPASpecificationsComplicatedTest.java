package com.itlize.marketplace.query;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import java.util.List;
import com.itlize.marketplace.entities.Product;
import com.itlize.marketplace.entities.UserLogin;
import com.itlize.marketplace.repositories.EntitiesJpaConfig;
import com.itlize.marketplace.repositories.ProductRepository;
import com.itlize.marketplace.repositories.UserLoginRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EntitiesJpaConfig.class})
@Transactional
public class JPASpecificationsComplicatedTest {

  @Autowired
  private UserLoginRepository userLoginRepository;
  private UserLogin userLogin1;
  private UserLogin userLogin2;
  private UserLogin userLogin3;

  @Autowired
  private ProductRepository productRepository;
  private Product product1;
  private Product product2;
  private Product product3;

  @Test
  public void load_repositories_successfully() {
    assertNotNull(userLoginRepository);
    assertNotNull(productRepository);
  }

  @Before
  public void init() {
    userLogin1 = new UserLogin();
    userLogin1.setEmail("test@email.com");
    userLogin1.setPassword("password");

    userLogin2 = new UserLogin();
    userLogin2.setPassword("secret");
    userLogin2.setUsername("username");

    userLogin3 = new UserLogin();
    userLogin3.setEmail("test@email.com");
    userLogin3.setPassword("random");
    userLogin3.setUsername("username");

    userLoginRepository.save(userLogin1);
    userLoginRepository.save(userLogin2);
    userLoginRepository.save(userLogin3);

    product1 = new Product();
    product1.setCategory("mechanical");
    product1.setModelYear(2000);
    product1.setSubCategory("hvac fans");

    product2 = new Product();
    product2.setCategory("MECHANICAL");
    product2.setModelYear(2005);
    product2.setSubCategory("HVAC FANS");

    product3 = new Product();
    product3.setCategory("electrical");
    product3.setModelYear(2010);
    product3.setSubCategory("laptop");

    productRepository.save(product1);
    productRepository.save(product2);
    productRepository.save(product3);
  }

  @Test
  public void exact_match_2terms() {
    UserLoginSpecification spec1 =
        new UserLoginSpecification(new SearchCriteria("email", ":", "test@email.com"));
    UserLoginSpecification spec2 =
        new UserLoginSpecification(new SearchCriteria("password", ":", "password"));

    List<UserLogin> results = userLoginRepository.findAll(spec1.and(spec2));
    assertTrue(results.contains(userLogin1));
    assertFalse(results.contains(userLogin2));
    assertFalse(results.contains(userLogin3));

    spec1 = new UserLoginSpecification(new SearchCriteria("email", ":", "test"));
    spec2 = new UserLoginSpecification(new SearchCriteria("password", ":", "pass"));

    results = userLoginRepository.findAll(spec1.and(spec2));
    assertFalse(results.contains(userLogin1));
    assertFalse(results.contains(userLogin2));
    assertFalse(results.contains(userLogin3));
  }

  @Test
  public void at_least_match_1term() {
    UserLoginSpecification spec1 =
        new UserLoginSpecification(new SearchCriteria("email", ":", "test@email.com"));
    UserLoginSpecification spec2 =
        new UserLoginSpecification(new SearchCriteria("password", ":", "secret"));

    List<UserLogin> results = userLoginRepository.findAll(spec1.or(spec2));
    assertTrue(results.contains(userLogin1));
    assertTrue(results.contains(userLogin2));
    assertTrue(results.contains(userLogin3));
  }

  @Test
  public void all_3_match() {
    ProductSpecification spec1 =
        new ProductSpecification(new SearchCriteria("category", ":", "mechanical"));
    ProductSpecification spec2 =
        new ProductSpecification(new SearchCriteria("modelYear", "=", 2000));
    ProductSpecification spec3 =
        new ProductSpecification(new SearchCriteria("subCategory", ":", "hvac fans"));

    List<Product> results = productRepository.findAll(spec1.and(spec2).and(spec3));
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));
  }

  @Test
  public void fun_match() {
    ProductSpecification spec1 =
        new ProductSpecification(new SearchCriteria("category", ":", "mechanical"));
    ProductSpecification spec2 =
        new ProductSpecification(new SearchCriteria("category", ":", "MECHANICAL"));
    ProductSpecification spec3 =
        new ProductSpecification(new SearchCriteria("modelYear", "<", 2005));
    ProductSpecification spec4 =
        new ProductSpecification(new SearchCriteria("modelYear", ">", 2005));
    ProductSpecification spec5 =
        new ProductSpecification(new SearchCriteria("subCategory", ":", "hvac fans"));
    ProductSpecification spec6 =
        new ProductSpecification(new SearchCriteria("subCategory", ":", "laptop"));

    List<Product> results = productRepository.findAll(spec1.or(spec2));
    assertTrue(results.contains(product1));
    assertTrue(results.contains(product2));
    assertFalse(results.contains(product3));

    results = productRepository.findAll(spec1.or(spec2).and(spec3));
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));

    results = productRepository.findAll(spec1.or(spec2).and(spec3.or(spec4)));
    assertTrue(results.contains(product1));
    assertFalse(results.contains(product2));
    assertFalse(results.contains(product3));

    results = productRepository.findAll(spec6.or(Specification.not(spec5)));
    assertFalse(results.contains(product1));
    assertTrue(results.contains(product2));
    assertTrue(results.contains(product3));

  }


}
