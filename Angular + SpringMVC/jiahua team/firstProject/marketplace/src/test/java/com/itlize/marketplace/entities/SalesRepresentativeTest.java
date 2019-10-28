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
public class SalesRepresentativeTest {

  @Autowired
  private SessionFactory sessionFactory;

  @Test
  public void salesRepresentative_save_fouond() {
    String name = "Marty McFly";
    long phone = 6508896222l;
    String email = "marty@mcfly.com";
    String web = "http://www.test.com";

    SalesRepresentative salesRepresentative = new SalesRepresentative();
    salesRepresentative.setEmail(email);
    salesRepresentative.setName(name);
    salesRepresentative.setPhone(phone);
    salesRepresentative.setWeb(web);

    Session session = sessionFactory.getCurrentSession();
    long id = (Long) session.save(salesRepresentative);

    SalesRepresentative foundSalesRepresentative = session.find(SalesRepresentative.class, id);
    assertEquals(salesRepresentative, foundSalesRepresentative);
  }
}
