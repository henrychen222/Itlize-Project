package com.itlize.marketplace.repositories;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Resource;
import com.itlize.marketplace.entities.Categories;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {EntitiesJpaConfig.class},
    loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext
public class CategoriesTest {

  @Resource
  private CategoriesRepository categoriesRepository;

  @Test
  public void givenCategories_whenSave_thenGetOK() {
    String category = "Mechanical";
    String subCategory = "HVAC fans";
    Map<String, String> attributes = new HashMap<String, String>() {
      private static final long serialVersionUID = 1L;
      {
        put("attr1", "value1");
        put("attr2", "value2");
        put("attr3", "value3");
        put("attr4", "value4");
        put("attr5", "value5");
      }
    };

    Categories categories = new Categories();
    categories.setCategory(category);
    categories.setSubCategory(subCategory);
    categories.setAttributes(attributes);

    Categories savedCategories = categoriesRepository.save(categories);
    assertEquals(categories, savedCategories);

  }

}
