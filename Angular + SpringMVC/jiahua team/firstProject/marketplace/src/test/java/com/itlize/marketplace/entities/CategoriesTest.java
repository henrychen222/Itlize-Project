package com.itlize.marketplace.entities;

import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Map;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import org.springframework.transaction.annotation.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {HibernateConfig.class},
    loader = AnnotationConfigContextLoader.class)
@Transactional
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class CategoriesTest {

  @Autowired
  private SessionFactory sessionFactory;

  @Test
  public void categories_save_found() {
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

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(categories);

    Categories foundCategories = session.find(Categories.class, id);
    assertEquals(categories, foundCategories);
  }
}
