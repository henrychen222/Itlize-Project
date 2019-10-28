package com.itlize.marketplace.entities;

import static org.junit.Assert.assertEquals;
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
public class ManufacturerTest {

  @Autowired
  private SessionFactory sessionFactory;

  @Test
  public void manufacturer_save_found() {
    String name = "Big Ass";
    String department = "Technical Support";
    long phone = 8004668200l;
    String email = "techsupport@bigass.com";
    String web = "http://www.bigassfans.com";

    Manufacturer manufacturer = new Manufacturer();
    manufacturer.setName(name);
    manufacturer.setDepartment(department);
    manufacturer.setPhone(phone);
    manufacturer.setEmail(email);
    manufacturer.setWeb(web);

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(manufacturer);

    Manufacturer foundManufacturer = session.find(Manufacturer.class, id);
    assertEquals(manufacturer, foundManufacturer);
  }
}
